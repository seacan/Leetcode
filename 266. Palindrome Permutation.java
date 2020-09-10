// Given a string, determine if a permutation of the string could form a palindrome.
// Input: "code", Output: false
// Input: "aab", Output: true
public class Solution {
    boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) set.add(c);
            else set.remove(c);
        }
        return set.isEmpty() || set.size() == 1;
    }
}