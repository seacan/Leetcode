public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] distance = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) distance[i][0] = i;
        for (int j = 0; j <= len2; j++) distance[0][j] = j;

        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                // consider the situation when cur char at w1 equals to w2
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    distance[i][j] = distance[i - 1][j - 1];
                else
                    distance[i][j] = Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1]) + 1;

        return distance[len1][len2];
    }
}