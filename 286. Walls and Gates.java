import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

// Solution 1: iteration
class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<com.solution.Pair> q = new PriorityQueue<>();
        List<com.solution.Pair> dirs = Arrays.asList(new com.solution.Pair(0, -1), new com.solution.Pair(-1, 0), new com.solution.Pair(0, 1), new com.solution.Pair(1, 0));
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0) q.offer(new com.solution.Pair(i, j));

        while (!q.isEmpty()) {
            int i = q.peek().x, j = q.peek().y;
            q.offer();
            for (int k = 0; k < dirs.size(); k++) {
                int x = i + dirs.get(k).x, y = j + dirs.get(k).y;
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < rooms[i][j] + 1)
                    continue;
                rooms[x][y] = rooms[i][j] + 1;
                q.offer(new com.solution.Pair(x, y));
            }
        }
    }
}