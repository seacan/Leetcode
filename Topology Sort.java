Solution 1: Search for node with 0 dependency
/**
* Definition for Directed graph.
* class DirectedGraphNode {
*     int label;
*     ArrayList<DirectedGraphNode> neighbors;
*     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
* };
*/
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph.size()==0) return res;

        //Construct hash map.
        Map<DirectedGraphNode, Set<DirectedGraphNode>> map = new HashMap<DirectedGraphNode, Set<DirectedGraphNode>>();
        for (DirectedGraphNode node: graph){
            Set<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
            map.put(node,set);
        }
        for (DirectedGraphNode node : graph)
            for (DirectedGraphNode temp: node.neighbors)
                map.get(temp).add(node);                

        //Construct topological order sequence.
        int len = graph.size();
        while (graph.size()>0) {
            int index = 0;
            while (index<graph.size()){
                DirectedGraphNode node = graph.get(index);
                if (map.get(node).size()==0){
                    graph.remove(node);
                    res.add(node);
                    for (DirectedGraphNode temp: graph)
                        if (map.get(temp).contains(node))
                            map.get(temp).remove(node);
                } else index++;
            }
        }
        return res;
    }
}


Solution 2: DFS search
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if (graph.size()==0) return res;
        Map<DirectedGraphNode,Integer> status = new HashMap<DirectedGraphNode,Integer>();
        for (DirectedGraphNode node: graph)
            status.put(node,0);

        while (hasUnsorted(status,graph)){
            DirectedGraphNode node = null;
            for (DirectedGraphNode temp : graph)
                if (status.get(temp)==0) node = temp;
            search(status, graph, res, node);
        }
        return res;          
    }
	
    public boolean hasUnsorted(Map<DirectedGraphNode,Integer> status, ArrayList<DirectedGraphNode> graph){
        for (DirectedGraphNode node : graph)
            if (status.get(node)==0) return true;
        return false;
    }

    public void search(Map<DirectedGraphNode,Integer> status, ArrayList<DirectedGraphNode> graph, ArrayList<DirectedGraphNode> res, DirectedGraphNode node){
        if (status.get(node)==1) System.out.println("It is not a DAG");
        if (status.get(node)==2) return;
        status.put(node,1);
        for (DirectedGraphNode next : node.neighbors)
            search(status,graph,res,next);
        status.put(node,2);
        res.add(0,node);
    }        
}