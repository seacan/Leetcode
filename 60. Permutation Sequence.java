public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);

        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) factor[i] = i * factor[i - 1];

        k--;
        StringBuilder sb = new StringBuilder();
        // iterate from n to 1 for n digits number
        for (int i = n; i > 0; i--) {
            // how many lower digits num requires decides the highest digit num
            int index = k / factor[i - 1];
            k %= factor[i - 1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }
}