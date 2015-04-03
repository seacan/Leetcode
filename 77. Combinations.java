public class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> sol = new ArrayList<Integer>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(1, n, k);
        return res;
    }
    
    private void combineHelper(int index, int n, int size) {
        if (sol.size() == size) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (sol.size() > size) return;
        for (int i = index; i <= n; i++) {
            sol.add(i);
            combineHelper(i + 1, n, size);
            sol.remove(sol.size() - 1);
        }
    }
}