public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsetsHelper(S, S.length);
    }

    public List<List<Integer>> subsetsHelper(int[] S, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }

        List<List<Integer>> pre = subsetsHelper(S, index - 1);
        res.addAll(pre);
        for (List<Integer> preSol : pre) {
            List<Integer> copy = new ArrayList<Integer>(preSol);
            copy.add(S[index - 1]);
            res.add(copy);
        }
        return res;
    }
}