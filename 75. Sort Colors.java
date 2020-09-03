// Solution 1. Move l and r pointer when current i is equal to 0 or 2
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int l = 0, r = A.length - 1;
        for (int i = 0; i <= r; i++)
            if (A[i] == 0) {
                if(i != l){
                    A[i--] = A[l];
                    A[l++] = 0;
                } else
                    l++;
            } else if (A[i] == 2) {
                if (i != r){
                    A[i--] = A[r];
                    A[r--] = 2;
                }
                else 
                    r--;
            }
                
    }
}

Solution 2: clean and easy to read
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            while (nums[i] == 2 && i < right) swap(nums, i, right--);
            while (nums[i] == 0 && i > left) swap(nums, i, left++);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}