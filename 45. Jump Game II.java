public class Solution {
    public int jump(int[] A) {
        int reach = 0, step = 0, lastIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > lastIndex) {
                // track the max location it can reach from last range
                lastIndex = reach;
                step++;
            }
            // track where it can reach
            reach = Math.max(reach, A[i] + i);
        }
        return step;
    }
}