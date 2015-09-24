public class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        int res = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i))) continue;
            if (s.charAt(i) == '(') {
                st.push(sign * st.peek());
                sign = 1;
            } else if (s.charAt(i) == ')') st.pop();
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    num = num * 10 + s.charAt(++i) - '0';
                res += num * sign * st.peek();
            }
        }
        return res;
    }
}