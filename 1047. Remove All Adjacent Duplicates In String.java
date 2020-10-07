// Input: "abbaca", Output: "ca"
class Solution {
    public String removeDuplicates(String S) {
        int cur = 0, n = S.length();
        char[] res = S.toCharArray();
        for (int i = 0; i < n; i++) {
            res[cur] = res[i];
            if (cur > 0 && res[cur - 1] == res[cur])
                cur -= 1;
            else cur++;
        }
        return new String(res, 0, cur);
    }
}