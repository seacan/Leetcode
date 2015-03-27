public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Stack<UndirectedGraphNode> st = new Stack<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

        st.push(node);
        while (!st.isEmpty()) {
            UndirectedGraphNode cur = st.pop();
            if (!map.containsKey(cur.label)) 
                map.put(cur.label, new UndirectedGraphNode(cur.label));

            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    st.push(neighbor);
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                // add to neighbor list
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}