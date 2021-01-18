class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // sort by end, if by start, consider test case [[1,100],[1,11],[2,12],[11,22]]
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end)            
                count++;
            else
                end = intervals[i][1];
        }

        return count;
    }
}