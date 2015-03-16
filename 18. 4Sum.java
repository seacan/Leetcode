public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 4) return res;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i - 1] == num[i]) continue;
            // j decreases to i+3
            for (int j = num.length - 1; j >= i + 3; j--) {
                if (j < num.length - 1 && num[j + 1] == num[j]) continue;
                int l = i + 1, r = j - 1;
                while (l < r) {
                    int sum = num[i] + num[l] + num[r] + num[j];
                    if (sum == target) {
                        res.add(new ArrayList<Integer>(Arrays.asList(num[i], num[l], num[r], num[j])));
                        do l++; while (l < r && num[l] == num[l - 1]);
                        do r--; while (l < r && num[r] == num[r + 1]);
                    } else if (sum > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        return res;
    }
}