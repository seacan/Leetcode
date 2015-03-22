public class Solution {
    public String simplifyPath(String path) {
        HashSet<String> symbols = new HashSet<String>(Arrays.asList("..", ".", ""));
        Stack<String> st = new Stack<String>();
        for (String s : path.split("/")) {
            if (s.equals("..") && !st.isEmpty()) st.pop();
            else if (!symbols.contains(s)) st.push(s);
        }
        String res = "";
        while (!st.isEmpty())
            res = "/" + st.pop() + res;
        // return slash if no path is there
        return res.isEmpty() ? "/" : res;
    }
}