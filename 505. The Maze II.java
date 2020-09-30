// Count the steps.
class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        Arrays.stream(dists).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        Queue<int[]> q = new PriorityQueue<>();
        q.offer(new int[]{start[0], start[1]});
        dists[start[0]][start[1]] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0], y = cur[1], dist = dists[cur[0]][cur[1]];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    ++dist;
                }
                x -= d[0];
                y -= d[1];
                --dist;
                if (dists[x][y] > dist) {
                    dists[x][y] = dist;
                    // no enqueue when hitting destination
                    if (x != destination[0] || y != destination[1]) q.offer(new int[]{x, y});
                }
            }
        }
        int res = dists[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}