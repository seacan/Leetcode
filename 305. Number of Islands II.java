// Count the number of islands after each addLand operation.
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] lands = new int[m * n];
        for (int i = 0; i < m * n; i++) lands[i] = -1;  // -1 as initial value

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            int curX = positions[i][0];
            int curY = positions[i][1];
            if (lands[curX * n + curY] != -1) continue;
            count++;
            lands[curX * n + curY] = curX * n + curY;
            for (int k = 0; k < neighbors.length; k++) {
                int nX = curX + neighbors[k][0];
                int nY = curY + neighbors[k][1];
                if (nX >= 0 && nX < m && nY >= 0 && nY < n && lands[nX * n + nY] != -1 && lands[nX * n + nY] != lands[curX * n + curY]) {
                    count--;
                    union(lands, lands[nX * n + nY], lands[curX * n + curY]);
                }
            }
            result.add(count);
        }
        return result;
    }

    private void union(int[] lands, int nId, int curId) {
        for (int i = 0; i < lands.length; i++) {
            if (lands[i] == nId) lands[i] = curId;
        }
    }
}