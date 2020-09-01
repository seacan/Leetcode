public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        if (s.indexOf("IV") != -1) sum -= 2;
        if (s.indexOf("IX") != -1) sum -= 2;
        if (s.indexOf("XL") != -1) sum -= 20;
        if (s.indexOf("XC") != -1) sum -= 20;
        if (s.indexOf("CD") != -1) sum -= 200;
        if (s.indexOf("CM") != -1) sum -= 200;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') sum += 1000;
            if (s.charAt(i) == 'D') sum += 500;
            if (s.charAt(i) == 'C') sum += 100;
            if (s.charAt(i) == 'L') sum += 50;
            if (s.charAt(i) == 'X') sum += 10;
            if (s.charAt(i) == 'V') sum += 5;
            if (s.charAt(i) == 'I') sum += 1;
        }
        return sum;
    }
}