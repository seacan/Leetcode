public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new LinkedList<Interval>();
        if (intervals == null || intervals.isEmpty()) return merged;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });

        for (int i = 0; i < intervals.size(); ) {
            Interval cur = intervals.get(i++);
            while (i < intervals.size())
                if (intervals.get(i).start <= cur.end) {
                    cur.end = Math.max(intervals.get(i).end, cur.end);
                    i++;
                } else
                    break;

            merged.add(cur);
        }
        return merged;
    }
}