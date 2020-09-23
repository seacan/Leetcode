/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serial(sb, root);
        return sb.toString();
    }

    private void serial(StringBuilder sb, Node root) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            if (root.children != null) {
                sb.append(root.children.size());
                sb.append(",");
                for (Node child: root.children)
                    serial(sb, child);                
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private Node buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) return null;        

        Node root = new Node(Integer.parseInt(val));
        int childrenCount = Integer.parseInt(queue.poll());

        root.children = new ArrayList<Node>();
        for (int i = 0; i <  childrenCount; i++)
            root.children.add(buildTree(queue));        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));