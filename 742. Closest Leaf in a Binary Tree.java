class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> back = new HashMap<>();
        TreeNode kNode = find(root, k, back);
        if (kNode == null) return -1;

        Queue<TreeNode> q = new PriorityQueue<>();
        q.offer(kNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(kNode);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left == null && t.right == null) return t.val;
            if (t.left != null && !visited.contains(t.left)) {
                visited.add(t.left);
                q.offer(t.left);
            }
            if (t.right != null && !visited.contains(t.right)) {
                visited.add(t.right);
                q.offer(t.right);
            }
            if (back.containsKey(t) && !visited.contains(back.get(t))) {
                visited.add(back.get(t));
                q.offer(back.get(t));
            }
        }
        return -1;
    }

    private TreeNode find(TreeNode node, int k, Map<TreeNode, TreeNode> back) {
        if (node.val == k) return node;
        if (node.left != null) {
            back.put(node.left, node);
            TreeNode left = find(node.left, k, back);
            if (left != null) return left;
        }
        if (node.right != null) {
            back.put(node.right, node);
            TreeNode right = find(node.right, k, back);
            if (right != null) return right;
        }
        return null;
    }
}