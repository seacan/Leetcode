public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        HashSet<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(operation(num2, num1, tokens[i]));
            } else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();
    }

    private int operation(int i, int j, String op) {
        switch (op) {
            case "+": return i + j;
            case "-": return i - j;
            case "*": return i * j;
            default: return i / j;
        }
    }
}