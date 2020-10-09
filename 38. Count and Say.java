// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char cur = pre.charAt(0);
        for (int i = 1; i < pre.length(); i++) {
            if (pre.charAt(i) != cur) {
                sb.append(count);
                sb.append(cur);
                cur = pre.charAt(i);
                count = 1;
            } else
                count++;
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
}