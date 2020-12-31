/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Stack<Node> st = new Stack<Node>();
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        st.push(node);
        map.put(node.val, new Node(node.val));
        while (!st.isEmpty()) {
            Node cur = st.pop();                         
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    st.push(neighbor);
                    map.put(neighbor.val, new Node(neighbor.val));
                }                
                map.get(cur.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return map.get(node.val);
    }
}