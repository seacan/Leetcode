public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        boolean isNegative = num1.charAt(0) == '-' ^ num2.charAt(0) == '-';
        num1 = num1.charAt(0) == '-' ? num1.substring(1) : num1;
        num2 = num2.charAt(0) == '-' ? num2.substring(1) : num2;

        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++)
            for (int j = 0; j < num2.length(); j++) {
                int cur = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // put i*j to i+j+1 position in res
                res[i + j + 1] += cur;
            }

        for (int i = res.length - 1; i >= 0; i--)
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;
                res[i] = res[i] % 10;
            }

        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        for (; startIndex < res.length; startIndex++)
            if (res[startIndex] != 0) break;
        for (; startIndex < res.length; startIndex++)
            sb.append(res[startIndex]);
        return isNegative ? "-" + sb.toString() : sb.toString();
    }
}