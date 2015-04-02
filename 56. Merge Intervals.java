public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new LinkedList<Interval>();
        if (intervals == null || intervals.isEmpty()) return merged;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) return i1.start - i2.start;
                else return i1.end - i2.end;
            }
        });

        for (int i = 0; i < intervals.size(); ) {
            merged.add(intervals.get(i++));
            for (; i < intervals.size() && intervals.get(i).start <= merged.get(merged.size() - 1).end; i++)
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, intervals.get(i).end);
        }
        return merged;
    }
}