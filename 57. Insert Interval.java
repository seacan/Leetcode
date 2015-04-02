// Solution 1: add to new list one by one
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) return new ArrayList<Interval>(Arrays.asList(newInterval));
        List<Interval> res = new ArrayList<Interval>();
        int i = 0;
        for (; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start)
                res.add(intervals.get(i));
            else if (intervals.get(i).start > newInterval.end)
                break;
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }

        res.add(newInterval);
        for (; i < intervals.size(); i++)
            res.add(intervals.get(i));
        return res;
    }
}

// Solution 2: add newInterval to list first, add element from intervals to list on two sides
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>(Arrays.asList(newInterval));
        if(intervals==null||intervals.size()==0) return res;

        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).end < newInterval.start)    
                res.add(res.size()-1, intervals.get(i));
            else if(intervals.get(i).end >= newInterval.start)    
                res.get(res.size()-1).start = Math.min(res.get(res.size()-1).start, intervals.get(i).start);

            if(intervals.get(i).start <= newInterval.end)    
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
            else 
                res.add(res.size(), intervals.get(i));
        }
        return  res;
    }
}