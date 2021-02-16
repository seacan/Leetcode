public class Solution {
    public int jump(int[] A) {
        int jumps = 0, curReach = 0, nextReach = 0;
        // A.length - 1 to avoid adding the last unnecessary jump, otherwise [1,1]->2
        for (int i = 0; i < A.length - 1; i++) {
            nextReach = Math.max(nextReach, i + A[i]);
            if (i == curReach) {
                jumps++;
                curReach = nextReach;
            }
        }
        return curReach < A.length - 1 ? -1 : jump;
    }
}