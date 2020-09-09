class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return new ArrayList<>();
        return recurSkyline(buildings, 0, buildings.length - 1);
    }

    private LinkedList<List<Integer>> recurSkyline(int[][] buildings, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            return mergeSkyline(recurSkyline(buildings, start, mid), recurSkyline(buildings, mid + 1, end));
        } else {
            LinkedList<List<Integer>> res = new LinkedList<>();
            res.add(Arrays.asList(buildings[start][0], buildings[start][2]));
            res.add(Arrays.asList(buildings[start][1], 0));
            return res;
        }
    }

    private LinkedList<List<Integer>> mergeSkyline(LinkedList<List<Integer>> l1, LinkedList<List<Integer>> l2) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        int h1 = 0, h2 = 0;
        while (l1.size() > 0 && l2.size() > 0) {
            int x = 0, h = 0;
            if (l1.getFirst().get(0) < l2.getFirst().get(0)) {
                x = l1.getFirst().get(0);
                h1 = l1.getFirst().get(1);
                h = Math.max(h1, h2);
                l1.removeFirst();
            } else if (l1.getFirst().get(0) > l2.getFirst().get(0)) {
                x = l2.getFirst().get(0);
                h2 = l2.getFirst().get(1);
                h = Math.max(h1, h2);
                l2.removeFirst();
            } else {
                x = l1.getFirst().get(0);
                h1 = l1.getFirst().get(1);
                h2 = l2.getFirst().get(1);
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if (res.size() == 0 || h != res.getLast().get(1))
                res.add(Arrays.asList(x, h));
        }
        if (l1.size() > 0) res.addAll(l1);
        if (l2.size() > 0) res.addAll(l2);
        return res;
    }
}