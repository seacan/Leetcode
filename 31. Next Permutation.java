public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;
        int index = num.length - 2;
        for (; index >= 0; index--)
            if (num[index] < num[index + 1])
                break;
        if (index != -1) {
            // find the smallest value greater then the value at cur position
            int minIndex = index + 1;
            for (int i = index + 1; i < num.length; i++)
                if (num[i] > num[index])
                    minIndex = i;
            int temp = num[minIndex];
            num[minIndex] = num[index];
            num[index] = temp;
            Arrays.sort(num, index + 1, num.length);
        } else Arrays.sort(num);
    }
}