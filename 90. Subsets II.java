public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (num == null || num.length == 0) return res;
        int last = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int j = (i > 0 && num[i - 1] == num[i]) ? last : 0;
            last = res.size();
            for (; j < last; j++) {
                List<Integer> copy = new ArrayList<Integer>(res.get(j));
                copy.add(num[i]);
                res.add(copy);
            }
        }
        return res;
    }
}