public class Solution {
    public List<List<Integer>> permute(int[] num) {
        return permuteHelper(num, num.length - 1);
    }

    private List<List<Integer>> permuteHelper(int[] num, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == 0) {
            res.add(new ArrayList<Integer>(Arrays.asList(num[index])));
            return res;
        }

        List<List<Integer>> pre = permuteHelper(num, index - 1);
        for (List<Integer> sol : pre) {
            for (int i = 0; i < sol.size() + 1; i++) {
                List<Integer> copy = new ArrayList<Integer>(sol);
                copy.add(i, num[index]);
                res.add(copy);
            }
        }
        return res;
    }
}