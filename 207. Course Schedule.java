public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
        inDegree.put(i, 0);
        map.put(i, new ArrayList<>());
    }
    for (int[] prerequisite : prerequisites) {
        inDegree.put(prerequisite[0], inDegree.get(prerequisite[0]) + 1);
        map.get(prerequisite[1]).add(prerequisite[0]);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
        if (entry.getValue() == 0)
            queue.add(entry.getKey());

    int count = 0;
    while (!queue.isEmpty()) {
        int cur = queue.poll();
        count++;
        for (int neighbor : map.get(cur)) {
            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
            if (inDegree.get(neighbor) == 0)
                queue.add(neighbor);
        }
    }
    return count == numCourses;
}