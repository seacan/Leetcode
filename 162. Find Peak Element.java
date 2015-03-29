public class Solution {
    public int findPeakElement(int[] num) {
        int l = 0, r = num.length - 1;
        while (l <= r) {
            if (l == r) return l;
            else if (l + 1 == r) return num[l] > num[r] ? l : r;
            else {
                int mid = (l + r) / 2;
                if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) return mid;
                else if (num[mid] > num[mid - 1] && num[mid] < num[mid + 1]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}