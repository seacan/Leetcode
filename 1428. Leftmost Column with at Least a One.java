/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     // BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 *     public List<Integer> dimensions {}
 * };
 */

// Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
// Output: 1
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();    
        int i = dimension.get(0) - 1, j = dimension.get(1) - 1, res = -1;
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