class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) continue;
            set.add(num);
            if (q.size() < 3) q.offer(num);
            else if (!q.isEmpty() && num > q.peek()) {
                q.poll();
                q.offer(num);
            }
        }
        if (q.size() < 3)
            while (q.size() > 1) q.poll();
        return q.peek();
    }
}