// Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> lists, int depth) {
        int res = 0;
        for (NestedInteger list : lists)
            res += NestedInteger.isInteger() ? NestedInteger.getInteger() * depth : helper(NestedInteger.getList(), depth + 1);        
        return res;
    }
}