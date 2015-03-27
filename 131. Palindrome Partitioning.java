public class Solution {
    private List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        partitionHelper(s, 0, new ArrayList<String>());
        return res;
    }

    private void partitionHelper(String s, int index, List<String> sol){
        if(index>=s.length()) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        for(int i=index;i<s.length();i++){
            String subString = s.substring(index, i+1);
            if(isPalindrome(subString)){
                sol.add(subString);
                partitionHelper(s, i + 1, sol);
                sol.remove(sol.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }
}