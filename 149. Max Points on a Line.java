class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < points.length - max; i++) {
            int samePoint = 0;
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                Double slope;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    samePoint++;
                    continue;
                } else if (points[i][0] == points[j][0])
                    slope = Double.MAX_VALUE;
                else if (points[i][1] == points[j][1])
                    slope = 0.0;
                else
                    slope = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }
            max = Math.max(max, 1 + samePoint + getMaxValue(map));
        }
        return max;
    }

    private int getMaxValue(Map<Double, Integer> map) {
        int max = 0;
        for (double key : map.keySet())
            max = Math.max(max, map.get(key));
        return max;
    }
}