public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;
        int index = num.length - 2;
        while (index >= 0 && num[index] >= num[index + 1]) index--;
        if (index >= 0) {
            // find rightmost first larger id j, which is the least num greater than index
            int j = num.length - 1;
            while (num[j] <= num[index]) j--;
            int temp = num[j];
            num[j] = num[index];
            num[index] = temp;
        }
        Arrays.sort(num, index + 1, num.length);
    }
}