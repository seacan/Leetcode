public class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
            else {
                if (st.isEmpty() || (c == ')' && st.peek() != '(') || (c == ']' && st.peek() != '[') || (c == '}' && st.peek() != '{'))
                    return false;
                st.pop();
            }
        }
        // return if stack is empty
        return st.isEmpty();
    }
}