// Input: 2
// Output: [0,1,3,2]
// Explanation:
// 00 - 0, 01 - 1, 11 - 3, 10 - 2
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }

        List<Integer> pre = grayCode(n - 1);
        res.addAll(pre);
        for (int i = pre.size() - 1; i >= 0; i--)
            // use pow function instead of ^
            res.add(pre.get(i) + (int)Math.pow(2, (n - 1)));
        return res;
    }
}