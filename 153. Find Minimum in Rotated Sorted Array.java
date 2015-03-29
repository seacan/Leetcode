public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length - 1;
        // <=, test case [1]
        while (l <= r) {
            if (num[l] <= num[r])
                return num[l];
            int mid = (l + r) / 2;
            // test case, [2,1]
            if (num[l] <= num[mid]) l = mid + 1;
            // test case, [3,1,2]
            else r = mid;
        }
        return -1;
    }
}