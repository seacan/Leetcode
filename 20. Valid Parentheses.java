public class Solution {
    // Solution 1: push the left parentheses, check paired right parentheses.
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

    // Solution 2: push the right parentheses, check equal left parentheses.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}