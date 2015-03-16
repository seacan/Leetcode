public class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
            else {
                if (st.empty()) return false;
                char top = st.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
                    return false;
            }
        }
        // return if stack is empty
        return st.isEmpty();
    }
}