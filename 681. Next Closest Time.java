// Input: "19:34"
// Output: "19:39"
// Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
class Solution {
    public String nextClosestTime(String time) {
        char[] res = new char[4];
        int[] v = {600, 60, 10, 1};
        int found = time.indexOf(":");
        int cur = Integer.parseInt(time.substring(0, found)) * 60 + Integer.parseInt(time.substring(found + 1));
        for (int i = 1, d = 0; i <= 1440; ++i) {
            int next = (cur + i) % 1440;
            for (d = 0; d < 4; ++d) {
                res[d] = (char) (next / v[d]);
                next %= v[d];
                if (time.indexOf(res[d]) == -1) break;
            }
            if (d >= 4) break;
        }
        String stringRes = new String(res);
        return stringRes.substring(0, 2) + ":" + stringRes.substring(2);
    }
}