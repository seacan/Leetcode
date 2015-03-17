public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;
        int index = num.length - 1;
        for (; index >= 1; index--)
            if (num[index - 1] < num[index])
                break;
        if (index != 0) {
            // find the smallest value greater then the value at cur position
            index--;
            int minIndex = index + 1;
            for (int i = index + 1; i < num.length; i++)
                if (num[i] > num[index])
                    minIndex = i;
            int temp = num[minIndex];
            num[minIndex] = num[index];
            num[index] = temp;
            Arrays.sort(num, index + 1, num.length);
        } else {
            Arrays.sort(num);
        }

        
    }
}