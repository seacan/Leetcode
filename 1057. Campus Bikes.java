// Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
// Output: [0,2,1]
// Explanation: 
// Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1.
// So the output is [0,2,1].
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;
        int n = bikes.length;
        int[] res = new int[m];

        boolean[] wUsed = new boolean[m];
        boolean[] bUsed = new boolean[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                minHeap.add(new int[]{i, j, dist(workers[i], bikes[j])});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (wUsed[cur[0]] || bUsed[cur[1]]) continue;
            res[cur[0]] = cur[1];
            wUsed[cur[0]] = true;
            bUsed[cur[1]] = true;
        }

        return res;
    }

    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}