class Pair {
    int col;
    TreeNode node;

    public Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> m = new HashMap<>();
        Queue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!m.containsKey(cur.col))
                m.put(cur.col, new ArrayList<>());
            m.get(cur.col).add(cur.node.val);
            if (cur.node.left != null) q.offer(new Pair(cur.col - 1, cur.node.left));
            if (cur.node.right != null) q.offer(new Pair(cur.col + 1, cur.node.right));
        }
        for (List<Integer> value : m.values()) {
            res.add(value);
        }
        return res;
    }
}