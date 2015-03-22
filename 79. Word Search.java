public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] searched = new boolean[board.length][board[0].length];
                    searched[i][j] = true;
                    // recursive on substring(1)
                    if (search(board, searched, i, j, word.substring(1))) return true;
                }
            }
        return false;
    }

    private boolean search(char[][] board, boolean[][] searched, int i, int j, String word) {
        if (word.length() == 0) return true;
        List<Integer> row = new ArrayList<Integer>(Arrays.asList(1, -1, 0, 0));
        List<Integer> col = new ArrayList<Integer>(Arrays.asList(0, 0, 1, -1));
        for (int k = 0; k < 4; k++) {
            int newRow = row.get(k) + i, newCol = col.get(k) + j;
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length)
                if (board[newRow][newCol] == word.charAt(0) && !searched[newRow][newCol]) {
                    searched[newRow][newCol] = true;
                    if (search(board, searched, newRow, newCol, word.substring(1)))
                        return true;
                    searched[newRow][newCol] = false;
                }
        }
        return false;
    }
}