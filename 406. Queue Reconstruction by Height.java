// A pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sorted by h first, within the same group of h, sorted by k
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);        
        return list.toArray(new int[list.size()][]);
    }
}