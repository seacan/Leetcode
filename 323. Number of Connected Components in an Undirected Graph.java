class Solution {
    public int countComponents(int n, List<Pair> edges) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (Pair edge : edges) {
            if (!map.containsKey(edge.x)) map.put(edge.x, new ArrayList<>());
            if (!map.containsKey(edge.y)) map.put(edge.y, new ArrayList<>());
            map.get(edge.x).add(edge.y);
            map.get(edge.y).add(edge.x);
        }
        for (int i = 0; i < n; i++)
            if (!visited.contains(i)) {
                res++;
                dfs(map, visited, i);
            }        
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int i) {
        if (visited.contains(i)) return;
        visited.add(i);
        for (int j = 0; j < map.get(i).size(); j++)
            dfs(map, visited, map.get(i).get(j));
    }
}