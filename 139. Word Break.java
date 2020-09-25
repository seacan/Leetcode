class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict.contains(s)) return true;
        List<Integer> index = new ArrayList<Integer>();
        index.add(0);
        for (int i = 1; i <= s.length(); i++) {            
            for (Integer start : index)
                if (wordDict.contains(s.substring(start, i))) {
                    index.add(0, i);
                    break;
                }            
        }
        return index.get(0) == s.length();
    }
}