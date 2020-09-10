// Find all strobogrammatic numbers that are of length = n.
// n = 0:   none
// n = 1:   0, 1, 8
// n = 2:   11, 69, 88, 96
// n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
public class Solution {
    List<String> findStrobogrammatic(int n) {
        List<String> odd = Arrays.asList("0", "1", "8"), even = Arrays.asList("");
        List<String> res = n % 2 == 1 ? odd : even;
        for (int i = (n % 2) + 2; i <= n; i += 2) {
            List<String> cur = new ArrayList<>();
            for (String s : res) {
                if (i != n) cur.add("0" + s + "0");
                cur.add("1" + s + "1");
                cur.add("6" + s + "9");
                cur.add("8" + s + "8");
                cur.add("9" + s + "6");
            }
            res = cur;
        }
        return res;
    }
}