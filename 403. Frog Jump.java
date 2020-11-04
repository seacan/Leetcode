// [0,1,3,5,6,8,12,17]
// Return true. The frog can jump to the last stone by jumping 
// 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
// 2 units to the 4th stone, then 3 units to the 6th stone, 
// 4 units to the 7th stone, and 5 units to the 8th stone.
class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) return true;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], new HashSet<Integer>());
        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1])
                    return true;
                HashSet<Integer> set = map.get(reach);
                // ignore non existing steps
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}