/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < points.length - max; i++) {
            int samePoint = 0;
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                Double slope;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                    continue;
                } else if (points[i].x == points[j].x)
                    slope = Double.MAX_VALUE;
                else if (points[i].y == points[j].y)
                    slope = 0.0;
                else
                    slope = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
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