class MagicDictionary {

    private Map<String, List<int[]>> map;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();    
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary)
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[] {i, s.charAt(i)};
                
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }        
    }
    
    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            String key = searchWord.substring(0, i) + searchWord.substring(i + 1);
            if (map.containsKey(key))
                for (int[] pair : map.get(key))
                    if (pair[0] == i && pair[1] != searchWord.charAt(i)) return true;               
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */