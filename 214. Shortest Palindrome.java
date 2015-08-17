// solution 1. n
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String curs = s + " " + new StringBuilder(s).reverse().toString();
        int[] trace = new int[curs.length()];
        for (int i = 1; i < curs.length(); i++) {
            int curIndex = trace[i - 1];
            while (curIndex > 0 && curs.charAt(curIndex) != curs.charAt(i))
                curIndex = trace[curIndex - 1];
            if (curs.charAt(curIndex) == curs.charAt(i))
                trace[i] = curIndex + 1;
        }
        return new StringBuilder(s.substring(trace[curs.length() - 1])).reverse().toString() + s;
    }
}


// solution 2. n^2
public class Solution {
    private String res = null;
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        res = s + s;
        for (int i = 0; i < s.length(); i++) {
            search(s, i, i);
            search(s, i, i + 1);
            search(s, i - 1, i);
        }

        return res;
    }

    private void search(String s, int l, int r) {
        for (; l >= 0 && r < s.length(); l--, r++)
            if (s.charAt(l) != s.charAt(r)) return;
        if (l == -1 && res.length() > s.length() + s.length() - r)
            res = new StringBuilder(s.substring(r)).reverse().toString() + s;
        if (r == s.length() && res.length() > s.length() + s.length() - l + 1)
            res = s + new StringBuilder(s.substring(0, ++l)).reverse().toString();
    }
}