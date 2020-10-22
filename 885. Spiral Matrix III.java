class Solution {
    public int[][] spiralMatrixIII(int R, int C, int x, int y) {
        int[][] res = new int[R * C][2];
        int dx = 0, dy = 1, n = 0, tmp;
        for (int j = 0; j < R * C; ++n) {
            // n controls the edge size, increase 1 by exploring two edges
            for (int i = 0; i < n / 2 + 1; ++i) {
                if (0 <= x && x < R && 0 <= y && y < C)
                    res[j++] = new int[] {x, y};
                x += dx;
                y += dy;
            }
            // 0,1 -> 1,0 -> 0,-1 -> -1,0
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
    }
}