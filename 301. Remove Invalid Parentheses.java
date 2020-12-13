// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
// Input: "(a)())()"
// Output: ["(a)()()", "(a())()"]
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;  // global checker
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    res.add(cur);
                    found = true;
                }
                if (!found) {
                    for (int i = 0; i < cur.length(); i++) {
                        char c = cur.charAt(i);
                        if (Character.isLetter(c)) continue;
                        String str = cur.substring(0, i) + cur.substring(i + 1);
                        if (!visited.contains(str)) {
                            queue.offer(str);
                            visited.add(str);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}