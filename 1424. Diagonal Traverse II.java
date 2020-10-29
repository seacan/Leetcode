// Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
// Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // The values from the bottom rows are the starting values of the diagonals.
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int totalNum = 0;
        for (int r = nums.size() - 1; r >= 0; --r)
            for (int c = 0; c < nums.get(r).size(); ++c) {
                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                totalNum++;
            }

        int[] ans = new int[totalNum];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int v : entry.getValue()) ans[index++] = v;
        }
        return ans;
    }
}