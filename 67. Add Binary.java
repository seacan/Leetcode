public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pad = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int cur = (i >= 0 ? (a.charAt(i) - '0') : 0) + (j >= 0 ? (b.charAt(j) - '0') : 0) + pad;
            sb.insert(0, cur % 2);
            pad = cur / 2;
        }
        
        if (pad == 1) sb.insert(0, pad);
        return sb.toString();
    }
}