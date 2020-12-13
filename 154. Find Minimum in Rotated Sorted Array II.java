public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length - 1;
        while (l <= r) {
            if (num[l] < num[r] || l == r)
                return num[l];
            int mid = (l + r) / 2;
            if (num[l] < num[mid]) l = mid + 1;
            else if (num[l] > num[mid]) r = mid;
            else l++;
        }
        return -1;
    }
}