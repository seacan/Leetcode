public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<Integer>();
        return spiralOrderHelper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private List<Integer> spiralOrderHelper(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) return null;
        List<Integer> result = new ArrayList<Integer>();
        
        // for 1 dimension, if doesn't handle specifically, 4 for loops will traverse 1st row and last row twice
        if (rowStart == rowEnd) {
            for (int i = colStart; i <= colEnd; i++) result.add(matrix[rowStart][i]);
            return result;
        }
        if (colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) result.add(matrix[i][colStart]);
            return result;
        }
        
        for (int i = colStart; i <= colEnd; i++) result.add(matrix[rowStart][i]);
        for (int i = rowStart + 1; i <= rowEnd; i++) result.add(matrix[i][colEnd]);
        for (int i = colEnd - 1; i >= colStart; i--) result.add(matrix[rowEnd][i]);
        for (int i = rowEnd - 1; i >= rowStart + 1; i--) result.add(matrix[i][colStart]);
        List<Integer> rest = spiralOrderHelper(matrix, rowStart + 1, colStart + 1, rowEnd - 1, colEnd - 1);
        // addAll doesn't support add null
        if (rest != null)   result.addAll(rest);
        return result;
    }
}