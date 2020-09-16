class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        int count = 0;
        while (!maxHeap.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> waitList = new LinkedList<>();
            int i = n + 1;
            for (; i > 0 && !maxHeap.isEmpty(); i--) {
                count++;
                Map.Entry<Character, Integer> cur = maxHeap.poll();
                if (cur.getValue() > 1) {
                    cur.setValue(cur.getValue() - 1);
                    waitList.offer(cur);
                }
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) count += i;
        }
        return count;
    }
}