public class Solution {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;

        for (int cur = 1; cur <= n; cur++)
            for (int i = 0; i < cur; i++)
                res[cur] += res[i] * res[cur - 1 - i];

        return res[n];
    }
}