class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] ones = new int[matrix[0].length + 1];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> st = new Stack<Integer>();
            st.push(-1);
            for (int j = 0; j <= matrix[0].length; j++) {
                ones[j] = j == matrix[0].length ? 0 : (matrix[i][j] == '1' ? ones[j] + 1 : 0);
                while (st.peek() != -1 && ones[j] < ones[st.peek()])
                    max = Math.max(max, ones[st.pop()] * (j - 1 - st.peek()));
                st.push(j);
            }
        }
        return max;
    }
}