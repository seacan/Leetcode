public class Solution {
    // Solution 1: copy matching element to right
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int index = A.length - 1;
        // check <= index
        for (int i = 0; i <= index; i++)
            if (A[i] == elem)
                A[i--] = A[index--];
        // return index+1
        return index + 1;
    }

    // Solution 2: copy non matching element to left
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val) nums[cur++] = nums[i];
        return cur;
    }
}