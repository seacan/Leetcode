// INF  -1  0  INF          3  -1   0   1
// INF INF INF  -1          2   2   1  -1
// INF  -1 INF  -1          1  -1   2  -1
//   0  -1 INF INF          0  -1   3   4

// Solution 1: recursion
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
    }

    void dfs(int[][] rooms, int i, int j, int val) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < val) return;
        rooms[i][j] = val;
        dfs(rooms, i + 1, j, val + 1);
        dfs(rooms, i - 1, j, val + 1);
        dfs(rooms, i, j + 1, val + 1);
        dfs(rooms, i, j - 1, val + 1);
    }
}

// Solution 2: iteration
class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair> q = new PriorityQueue<>();
        List<Pair> dirs = Arrays.asList(new Pair(0, -1), new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0));
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0) q.offer(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int i = cur.x, j = cur.y;
            for (int k = 0; k < dirs.size(); k++) {
                int x = i + dirs.get(k).x, y = j + dirs.get(k).y;
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < rooms[i][j] + 1)
                    continue;
                rooms[x][y] = rooms[i][j] + 1;
                q.offer(new Pair(x, y));
            }
        }
    }
}