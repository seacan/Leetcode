public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> list = new LinkedList<Integer>();
        Queue<Integer> q = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1) {
                res[i - k] = q.peek();
                q.remove(list.pollFirst());
            }

            list.addLast(nums[i]);
            q.offer(nums[i]);

        }
        res[res.length - 1] = q.peek();
        return res;
    }
}