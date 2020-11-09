class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, num = 0, curRes = 0;
        char sign = '+';
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) continue;
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        curRes += num;
                        break;
                    case '-':
                        curRes -= num;
                        break;
                    case '*':
                        curRes *= num;
                        break;
                    case '/':
                        curRes /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == s.length() - 1) {
                    res += curRes;
                    curRes = 0;
                }
                sign = c;
                num = 0;
            }
        }
        return res;
    }
}

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i))) continue;
            if (Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i) - '0';
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (sign == '-') st.push(-num);
                if (sign == '+') st.push(num);
                if (sign == '*') st.push(st.pop() * num);
                if (sign == '/') st.push(st.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int n : st) res += n;
        return res;
    }
}