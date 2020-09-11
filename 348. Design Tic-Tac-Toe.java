class TicTacToe {

    public TicTacToe(int n) {
        this.diag = 0;
        this.rev_diag = 0;
        this.N = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        this.rows[row] += add;
        this.cols[col] += add;
        this.diag += (row == col ? add : 0);
        this.rev_diag += (row + col == this.N - 1 ? add : 0);
        return (Math.abs(this.rows[row]) == N ||
                Math.abs(this.cols[col]) == N ||
                Math.abs(this.diag) == N ||
                Math.abs(this.rev_diag) == N) ? player : 0;
    }

    private:
    int[] rows, cols;
    int diag, rev_diag, N;
}