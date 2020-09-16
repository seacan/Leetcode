class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) start = m.get(node);
                if (i == size - 1) end = m.get(node);
                if (node.left != null) {
                    m.put(node.left, m.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    m.put(node.right, m.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
}