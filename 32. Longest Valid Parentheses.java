public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                st.pop();
                int index = st.isEmpty() ? -1 : st.peek();
                // length computation is based on current index and next top in stack
                longest = Math.max(longest, i - index);
            } else
                st.push(i);
        }
        return longest;
    }
}