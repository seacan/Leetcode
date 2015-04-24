// solution 1: DP
public class Solution {
    public int numDistinct(String S, String T) {
        if (T.length() > S.length()) return 0;
        int[] mem = new int[T.length() + 1];
        mem[0] = 1;
        for (int i = 0; i < S.length(); i++)
            for (int j = T.length(); j >= 1; j--)
                if (S.charAt(i) == T.charAt(j - 1))
                    mem[j] += mem[j - 1];
        return mem[T.length()];
    }
}



// solution 2: indexes
public class Solution {
    public int numDistinct(String S, String T) {
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) map.put(S.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
            else map.get(S.charAt(i)).add(i);
        }
        numDistinctHelper(T, map, new ArrayList<Integer>());
        return count;
    }

    private Integer count = 0;
    private void numDistinctHelper(String T, HashMap<Character, List<Integer>> map, List<Integer> sol){
        if(T.isEmpty()){
            count++;
            return;
        }
        char cur = T.charAt(0);
        if(map.containsKey(cur)) {
            if (sol.size() == 0) {
                for (Integer index : map.get(cur)) {
                    sol.add(index);
                    numDistinctHelper(T.substring(1), map, sol);
                    sol.remove(sol.size() - 1);
                }
            } else {
                for (Integer index : map.get(cur))
                    if (index > sol.get(sol.size() - 1)) {
                        sol.add(index);
                        numDistinctHelper(T.substring(1), map, sol);
                        sol.remove(sol.size() - 1);
                    }
            }
        }
    }
}