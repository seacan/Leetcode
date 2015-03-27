public class Solution {
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num)
            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int total = left + right + 1;
                map.put(n, total);

                res = Math.max(res, total);
                map.put(n - left, total);
                map.put(n + right, total);
            }
        return res;
    }
}