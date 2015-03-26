public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < curRow.size(); j++)
                curRow.set(j, Math.min(nextRow.get(j), nextRow.get(j + 1)) + curRow.get(j));
        }
        return triangle.get(0).get(0);
    }
}