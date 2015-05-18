public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            int[] ret = new int[numCourses];
            for(int i=0;i<numCourses;i++) ret[i] = i;
            return ret;
        };
        
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new HashSet<Integer>();
        for (int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][0]].add(prerequisites[i][1]);
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++){
            if (!visited[i] && !search(i, visited, visiting, graph, res))
                return new int[0];
        }

        int[] ret = new int[res.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = res.get(i);
        return ret;
    }
    
    private boolean search(int i,boolean[] visited,boolean[] visiting, HashSet<Integer>[] graph, List<Integer> res) {
        if (visiting[i]) return false;
        visiting[i] = true;
        for (Integer j : graph[i])
            if (!visited[j] && !search(j, visited, visiting, graph, res))
                return false;
        visiting[i] = false;
        visited[i] = true;
        res.add(i);
        return true;
    }
}