// for int case
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


// for double case
private double delta = 0.001;
public double sqrt(int x) {
    if (x == 0 || x == 1) return x;
    double l = 1, r = x, res = 1;
    while (l + delta < r) {
        double mid = (r + l) / 2;
        if (mid * mid <= x) {
            res = mid;
            l = mid + delta;
        } else r = mid - delta;
    }
    return res;
}