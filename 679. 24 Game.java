// Input: [4, 1, 8, 7]
// Output: True
// Explanation: (8-4) * (7-1) = 24
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    // Choose two cards for every round of dfs
    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {        
            if (Math.abs(list.get(0)- 24.0) < 0.001)
                return true;            
            return false;
        }
        
        // choose two cards
        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    // add computed result to next round as one card
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if(k == j || k == i) continue;
                        nextRound.add(list.get(k));
                    }
                    if (dfs(nextRound)) return true;
                }
         
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
        return res;
    }
}