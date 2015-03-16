public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int l = i + 1, r = num.length - 1;
            while (l < r) {
                if (num[i] + num[l] + num[r] == 0) {
                    res.add(new ArrayList<Integer>(Arrays.asList(num[i], num[l], num[r])));
                    // move left and right only 1 solution is found, only move when l<r
                    // check l and its previous one, r and its afer one
                    do l++; while (l < r && num[l] == num[l - 1]);
                    do r--; while (l < r && num[r] == num[r + 1]);
                } else if (num[i] + num[l] + num[r] > 0)
                    r--;
                else
                    l++;
            }
        }
        return res;
    }
}