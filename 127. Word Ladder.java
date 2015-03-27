public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        HashMap<String, Integer> ladder = new HashMap<String, Integer>();
        for (String s : dict) ladder.put(s, Integer.MAX_VALUE);
        ladder.put(start, 1);

        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int step = ladder.get(cur) + 1;

            for (int i = 0; i < cur.length(); i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    String newString = cur.substring(0, i) + c + cur.substring(i + 1);
                    if (ladder.containsKey(newString)) {
                        if (newString.equals(end)) return step;
                        if (step > ladder.get(newString)) continue;
                        else if (step < ladder.get(newString)) {
                            queue.add(newString);
                            ladder.put(newString, step);
                        }
                    }
                }
        }
        return 0;
    }
}