class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;            
        }
        return max;
    }
}