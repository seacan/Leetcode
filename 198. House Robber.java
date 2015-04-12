public class Solution {
    public int rob(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return num[0];
        int[] cache = new int[num.length];
        cache[0] = num[0];
        cache[1] = num[0] > num[1] ? num[0] : num[1];
        for (int i = 2; i < num.length; i++)
            cache[i] = Math.max(cache[i - 2] + num[i], cache[i - 1]);
        return cache[num.length - 1];
    }
}