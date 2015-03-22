public class Solution {
	public void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		if (row == 0 || col == 0) return;

		boolean[] rowIndex = new boolean[row];
		boolean[] colIndex = new boolean[col];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (matrix[i][j] == 0) {
					rowIndex[i] = true;
					colIndex[j] = true;
				}

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (rowIndex[i] == true || colIndex[j] == true)
					matrix[i][j] = 0;
	}
}