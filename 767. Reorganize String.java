class Solution {
    public String reorganizeString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Map.Entry<Character, Integer> pre = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            res.append(cur.getKey());
            if (pre != null) maxHeap.offer(pre);
            cur.setValue(cur.getValue() - 1);
            pre = cur.getValue() > 0 ? cur : null;
        }
        return res.length() == str.length() ? res.toString() : "";
    }
}