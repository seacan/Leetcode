public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) {
            int res = 0;
            for (int n : num) res += n;
            return res;
        }

        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            int l = i + 1, r = num.length - 1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                if (sum == target) return target;
                else {
                    if (Math.abs(sum - target) < Math.abs(res - target))
                        res = sum;
                    if (sum >= target) r--;
                    else l++;
                }
            }
        }
        return res;
    }
}