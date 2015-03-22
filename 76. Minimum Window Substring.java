public class Solution {
    public String minWindow(String S, String T) {
        if (T.isEmpty()) return "";
            int total = T.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < T.length(); i++)
                map.put(T.charAt(i), map.containsKey(T.charAt(i)) ? map.get(T.charAt(i)) + 1 : 1);

            Deque<Integer> queue = new LinkedList<Integer>();
            String str = "";
            int minLength = S.length();
            for (int i = 0; i < S.length(); i++)
                if (map.containsKey(S.charAt(i))) {
                    queue.add(i);
                    map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
                    if (map.get(S.charAt(i)) >= 0) total--;

                    while (map.get(S.charAt(queue.peek())) < 0) {
                        int index = queue.poll();
                        // update the map for index
                        map.put(S.charAt(index), map.get(S.charAt(index)) + 1);
                    }

                    // use <= to update str when there is only 1 character
                    if (total == 0 && (queue.peekLast() - queue.peekFirst() + 1 <= minLength)) {
                        str = S.substring(queue.peekFirst(), queue.peekLast() + 1);
                        minLength = queue.peekLast() - queue.peekFirst() + 1;
                    }
                }
            return str;
        }
}