public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        table.put('A', 0);
        table.put('C', 1);
        table.put('G', 2);
        table.put('T', 3);

        List<String> res = new ArrayList<String>();
        if (s.length() < 10) return res;

        int sum = table.get(s.charAt(0)), div = 1;
        for (int i = 1; i <= 9; i++) {
            sum = sum * 4 + table.get(s.charAt(i));
            div *= 4;
        }

        int[] encoding = new int[s.length() - 9];
        encoding[0] = sum;
        for (int i = 1; i < encoding.length; i++)
            encoding[i] = encoding[i - 1] % div * 4 + table.get(s.charAt(i + 10 - 1));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < encoding.length; i++) {
            if (!map.containsKey(encoding[i]))
                map.put(encoding[i], i);
            else {
                int start = map.get(encoding[i]);
                if (start < 0) continue;
                map.put(encoding[i], -1);
                res.add(s.substring(start, start + 10));
            }
        }
        return res;
    }
}