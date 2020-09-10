// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
public class Solution {
    public static int findMinMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) return 0;

        Collections.sort(meetings, Comparator.comparingInt(a -> a.start));
        Queue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(), Comparator.comparingInt(a -> a.end));
        int minRooms = 0;
        for (Meeting meeting : meetings) {
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
                minHeap.poll();            
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}