public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++)
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;

        // minimize from right, consider test case [3,2,1]
        int total = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1 : candy[i];
            total += candy[i];
        }
        return total;
    }
}