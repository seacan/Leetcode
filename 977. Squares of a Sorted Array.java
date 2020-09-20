class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left = 0, right = A.length - 1, cur = res.length - 1;
        while (left <= right) {
            int leftSquare = (int) Math.pow(A[left], 2), rightSquare = (int) Math.pow(A[right], 2);
            if (leftSquare <= rightSquare) {
                res[cur--] = rightSquare;
                right--;
            } else {
                res[cur--] = leftSquare;
                left++;
            }
        }
        return res;
    }
}