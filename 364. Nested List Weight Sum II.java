class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        Queue<List<NestedInteger>> q = new PriorityQueue<>();
        q.offer(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                List<NestedInteger> t = q.poll();
                for (NestedInteger a : t) {
                    if (a.isInteger()) unweighted += a.getInteger();
                    else if (!a.getList().empty()) q.offer(a.getList());
                }
            }
            // Previous level is added again in the next loop
            weighted += unweighted;
        }
        return weighted;
    }
}