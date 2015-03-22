public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] ones = new int[matrix[0].length];
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ones[j] = matrix[i][j] == '1' ? ones[j] + 1 : 0;
                while (st.peek() != -1)
                    if (ones[j] < ones[st.peek()])
                        max = Math.max(max, ones[st.pop()] * (j - 1 - st.peek()));
                    else
                        break;
                st.push(j);
            }
            
            // last while is outside second for loop
            while (st.peek() != -1)
                    max = Math.max(max, ones[st.pop()] * (ones.length - 1 - st.peek()));
        }
        
        return max;
    }
}