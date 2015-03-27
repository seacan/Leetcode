class Pair {
    public int first;
    public int second;
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int i = 0; i < board[0].length; ++i)
            if (board[0][i] == 'O')
                markUnflippable(board, 0, i);

        for (int i = 0; i < board[board.length - 1].length; ++i)
            if (board[board.length - 1][i] == 'O')
                markUnflippable(board, board.length - 1, i);

        for (int i = 0; i < board.length; ++i)
            if (board[i][0] == 'O')
                markUnflippable(board, i, 0);

        for (int i = 0; i < board.length; ++i)
            if (board[i][board[i].length - 1] == 'O')
                markUnflippable(board, i, board[i].length - 1);

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++j)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'U')
                    board[i][j] = 'O';
    }

    private void markUnflippable(char[][] board, int row, int col) {
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(row, col));
        while (!st.isEmpty()) {
            Pair cur = st.pop();
            board[cur.first][cur.second] = 'U';
            for (int i = 0; i < x.length; i++) {
                int newRow = cur.first + x[i];
                int newCol = cur.second + y[i];
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length &&
                        board[newRow][newCol] == 'O')
                    st.push(new Pair(newRow, newCol));
            }
        }
    }
}