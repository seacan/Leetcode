class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> lists, int depth) {
        int res = 0;
        for (NestedInteger list : lists) {
            res += NestedInteger.isInteger() ? NestedInteger.getInteger() * depth : helper(NestedInteger.getList(), depth + 1);
        }
        return res;
    }
}