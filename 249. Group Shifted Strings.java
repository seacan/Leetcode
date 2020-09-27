// We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
// Input:  ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
// Output: [["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"]]
public class Solution {
    List<List<String>> groupStrings(List<String> strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            StringBuilder key = new StringBuilder();
            for (char c : str.toCharArray())
                // encoding the key
                key.append(((c + 26 - str.charAt(0)) % 26) + ",");
            if (!map.containsKey(key))
                map.put(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(str);
        }
        for (List<String> values : map.values())
            res.add(values);
        return res;
    }
}