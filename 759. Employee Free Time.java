package com.solution;

import java.util.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class EmployeeSchedule {
    Interval interval;
    int employeeIndex, scheduleIndex;

    public EmployeeSchedule(Interval interval, int employeeIndex, int scheduleIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.scheduleIndex = scheduleIndex;
    }
}

public class Main {
    public static List<Interval> findFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        Queue<EmployeeSchedule> minHeap =
                new PriorityQueue<EmployeeSchedule>(Comparator.comparingInt(a -> a.interval.start));
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeSchedule(schedule.get(i).get(0), i, 0));

        Interval lastInterval = null;
        while (!minHeap.isEmpty()) {
            EmployeeSchedule cur = minHeap.poll();
            if (lastInterval != null) {
                if (lastInterval.end < cur.interval.start)
                    res.add(new Interval(lastInterval.end, cur.interval.start));
                if (lastInterval.end < cur.interval.end)  // true if // lastInterval.end < cur.interval.start
                    lastInterval = cur.interval;
            } else
                lastInterval = cur.interval;

            if (schedule.get(cur.employeeIndex).size() > cur.scheduleIndex + 1) {
                minHeap.offer(new EmployeeSchedule(schedule.get(cur.employeeIndex).get(cur.scheduleIndex + 1),
                        cur.employeeIndex, cur.scheduleIndex + 1));
            }
        }
        return res;
    }   
}
