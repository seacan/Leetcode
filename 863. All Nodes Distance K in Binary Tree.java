class Solution {
    private Map<TreeNode, List<TreeNode>> map = new HashMap();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || K < 0) return res;
        buildMap(root);
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(TreeNode node) {
        map.putIfAbsent(node, new ArrayList<>());
        if (node.left != null) {
            map.putIfAbsent(node.left, new ArrayList<>());
            map.get(node).add(node.left);
            map.get(node.left).add(node);
            buildMap(node.left);
        }
        if (node.right != null) {
            map.putIfAbsent(node.right, new ArrayList<>());
            map.get(node).add(node.right);
            map.get(node.right).add(node);
            buildMap(node.right);
        }
    }
}