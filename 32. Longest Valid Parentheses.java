public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && st.peek() != -1 && s.charAt(st.peek()) == '(') {
                st.pop();
                longest = Math.max(longest, i - st.peek());
            } else
                st.push(i);
        }
        return longest;
    }
}