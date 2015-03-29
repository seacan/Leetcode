public class Solution {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) return "";
        String[] numInString = new String[num.length];
        for (int i = 0; i < num.length; i++) numInString[i] = Integer.toString(num[i]);
        Arrays.sort(numInString, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        if (numInString[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : numInString) sb.append(s);
        return sb.toString();
    }
}