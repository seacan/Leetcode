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