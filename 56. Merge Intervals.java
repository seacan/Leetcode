public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new LinkedList<Interval>();
        if (intervals == null || intervals.isEmpty()) return merged;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end;
            }
        });
        
        merged.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = merged.get(merged.size() - 1);
            if (last.end >= intervals.get(i).start)
                last.end = Math.max(last.end, intervals.get(i).end);
            else
                merged.add(intervals.get(i));
        }
        return merged;
    }
}