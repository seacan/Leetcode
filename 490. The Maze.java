class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return helper(maze, start[0], start[1], destination[0], destination[1]);
    }

    boolean helper(int[][] maze, int i, int j, int di, int dj) {
        if (i == di && j == dj) return true;
        boolean res = false;
        int m = maze.length, n = maze[0].length;
        maze[i][j] = -1;
        for (int[] dir : dirs) {
            int x = i, y = j;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if (maze[x][y] != -1)
                res |= helper(maze, x, y, di, dj);
        }
        return res;
    }
}

// Iterative solution.
class Solution {
    boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new PriorityQueue<>();
        q.offer(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            for (int[] d : dirs) {
                int x = cur[0], y = cur[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                }
                x -= d[0];
                y -= d[1];
                if (maze[x][y] != -1) {
                    maze[x][y] == -1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}