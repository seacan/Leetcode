// trip[i] = [num_passengers, start_location, end_location]
// Input: trips = [[2,1,5],[3,3,7]], capacity = 4
// Output: false
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> stops = new TreeMap<>();
        for (int t[] : trips) {
            if (!stops.containsKey(t[1])) stops.put(t[1], 0);
            if (!stops.containsKey(t[2])) stops.put(t[2], 0);
            stops.put(t[1], stops.get(t[1]) + t[0]);
            stops.put(t[2], stops.get(t[2]) - t[0]);
        }
        for (int stop : stops.keySet()) {
            capacity -= stops.get(stop);
            if (capacity < 0) break;
        }
        return capacity >= 0;
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int curCapacity = 0;
        for (int[] trip : trips) {
            while (!minHeap.isEmpty() && trip[1] >= minHeap.peek()[2])
                curCapacity -= minHeap.poll()[0];
            minHeap.offer(trip);
            curCapacity += trip[0];
            if (curCapacity > capacity) return false;
        }
        return true;
    }
}