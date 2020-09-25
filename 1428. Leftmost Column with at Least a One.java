/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int n = dimension.get(0);
        int m = dimension.get(1);
        int i = n - 1, j = m - 1, res = -1;
        while (i >= 0 && j >= 0) {
            int cur = binaryMatrix.get(i, j);
            if (cur == 0) {
                i--;
            } else {
                res = j;
                j--;
            }
        }
        return res;
    }
}