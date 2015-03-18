public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = new String(sArray);
            if (map.containsKey(key))
                map.get(key).add(s);
            else
                map.put(key, new ArrayList<String>(Arrays.asList(s)));
        }
        for (String s : map.keySet()) {
            List<String> array = map.get(s);
            if (array.size() != 1) res.addAll(array);
        }
        return res;
    }
}