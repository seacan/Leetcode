public class Solution {
    public int sqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        // must use <=, consider pass in 1
        while (l <= r) {
            // consider overflow, don't use mid*mid and l+r
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) l = mid + 1;
            else r = mid - 1;
        }
        return l - 1;
    }
}