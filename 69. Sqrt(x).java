public class Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                l = mid + 1;
                ans = mid;
            } else r = mid - 1;
        }
        return ans;
    }
}