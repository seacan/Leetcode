class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] lands = new int[m * n];
        for (int i = 0; i < m * n; i++) lands[i] = -1;

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            int pX = positions[i][0];
            int pY = positions[i][1];
            if (lands[pX * n + pY] != -1) continue;
            count++;
            lands[pX * n + pY] = pX * n + pY;
            for (int k = 0; k < neighbors.length; k++) {
                int nX = pX + neighbors[k][0];
                int nY = pY + neighbors[k][1];
                if (nX >= 0 && nX < m && nY >= 0 && nY < n && lands[nX * n + nY] != -1 && lands[nX * n + nY] != lands[pX * n + pY]) {
                    count--;
                    union(lands, lands[nX * n + nY], lands[pX * n + pY]);
                }
            }
            result.add(count);
        }
        return result;
    }

    private void union(int[] lands, int pId, int qId) {
        for (int i = 0; i < lands.length; i++) {
            if (lands[i] == qId) lands[i] = pId;
        }
    }
}