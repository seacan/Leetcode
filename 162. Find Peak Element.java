class Solution {
    public int findPeakElement(int[] num) {
        int l = 0, r = num.length - 1;
        while (l < r) {            
            int mid = (l + r) / 2;
            if (num[mid] >= num[mid + 1]) r = mid;                
            else l = mid + 1;
        }
        return l;
    }
}