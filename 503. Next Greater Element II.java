// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number; 
// The second 1's next greater number needs to search circularly, which is also 2.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                res[stack.pop()] = nums[i % n];
            stack.push(i % n);
        }
        return res;
    }
}