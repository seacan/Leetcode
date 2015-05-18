public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new HashSet<Integer>();
        for (int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][0]].add(prerequisites[i][1]);
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!visited[i] && !search(i, visited, visiting, graph))
                return false;
        return true;
    }

    private boolean search(int i,boolean[] visited,boolean[] visiting, HashSet<Integer>[] graph) {
        if (visiting[i]) return false;
        visiting[i] = true;
        for (Integer j : graph[i])
            if (!visited[j] && !search(j, visited, visiting, graph))
                return false;
        visiting[i] = false;
        visited[i] = true;
        return true;
    }
}