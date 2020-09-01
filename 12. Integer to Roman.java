public class Solution {
    // Solution 1: better performance.
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
    	while (num > 0) {
    	    // greater and equal than, continue to the next loop
    		if (num >= 1000) {
    			res.append("M");
    			num -= 1000;
    			continue;
    		}
    		if (num >= 900) {
    			res.append("CM");
    			num -= 900;
    			continue;
    		}
    		if (num >= 500) {
    			res.append("D");
    			num -= 500;
    			continue;
    		}
    		if (num >= 400) {
    			res.append("CD");
    			num -= 400;
    			continue;
    		}
    		if (num >= 100) {
    			res.append("C");
    			num -= 100;
    			continue;
    		}
    		if (num >= 90) {
    			res.append("XC");
    			num -= 90;
    			continue;
    		}
    		if (num >= 50) {
    			res.append("L");
    			num -= 50;
    			continue;
    		}
    		if (num >= 40) {
    			res.append("XL");
    			num -= 40;
    			continue;
    		}
    		if (num >= 10) {
    			res.append("X");
    			num -= 10;
    			continue;
    		}
    		if (num >= 9) {
    			res.append("IX");
    			num -= 9;
    			continue;
    		}
    		if (num >= 5) {
    			res.append("V");
    			num -= 5;
    			continue;
    		}
    		if (num >= 4) {
    			res.append("IV");
    			num -= 4;
    			continue;
    		}
    		if (num >= 1) {
    			res.append("I");
    			num -= 1;
    			continue;
    		}
    	}
    	return res.toString();
    }

    // Solution 2: easy for read.
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}