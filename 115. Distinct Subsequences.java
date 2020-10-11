// Input: S = "rabbbit", T = "rabbit"
// Output: 3
// solution 1: one string DP
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

// Solution 2: two strings DP
public class Solution {
    public int numDistinct(String S, String T) {
        int[][] mem = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) mem[i][0] = 1;
        for (int i = 1; i <= S.length(); i++)
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    mem[i][j] = mem[i - 1][j - 1] + mem[i - 1][j];
                else
                    mem[i][j] = mem[i - 1][j];
            }

        return mem[S.length()][T.length()];
    }
}

// solution 3: indexes
public int numDistinct(String S, String T) {
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) map.put(S.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
            else map.get(S.charAt(i)).add(i);
        }

        // push -1, for the first index in sol, any index can be picked
        numDistinctHelper(T, map, new ArrayList<Integer>(Arrays.asList(-1)));
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
            for (Integer index : map.get(cur))
                if (index > sol.get(sol.size() - 1)) {
                    sol.add(index);
                    numDistinctHelper(T.substring(1), map, sol);
                    sol.remove(sol.size() - 1);
                }
        }
    }