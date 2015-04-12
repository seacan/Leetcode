public class Solution {
    private List<List<String>> res = new ArrayList<List<String>>();
    private HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (dict.size() == 0) return res;

        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> ladder = new HashMap<String, Integer>();
        for (String s : dict) ladder.put(s, Integer.MAX_VALUE);
        ladder.put(start, 0);

        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int step = ladder.get(cur) + 1;
            if (step > min) break;

            for (int i = 0; i < cur.length(); i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    String newString = cur.substring(0, i) + c + cur.substring(i + 1);
                    if (ladder.containsKey(newString)) {
                        if (step > ladder.get(newString)) continue;
                        if (step < ladder.get(newString)) {
                            // enqueue and update step
                            queue.add(newString);
                            ladder.put(newString, step);
                        }

                        if (newString.equals(end)) min = step;
                        
                        // update back trace mapping
                        if (map.containsKey(newString))
                            map.get(newString).add(cur);
                        else
                            map.put(newString, new ArrayList<String>(Arrays.asList(cur)));
                    }
                }
        }
        backTrace(end, start, new ArrayList<String>());
        return res;
    }

    private void backTrace(String end, String start, List<String> sol) {
        if (end.equals(start)) {
            List<String> copy = new ArrayList<String>(sol);
            copy.add(0, start);
            res.add(copy);
            return;
        }

        sol.add(0, end);
        if (map.containsKey(end))
            for (String s : map.get(end))
                backTrace(s, start, sol);
        sol.remove(0);
    }
}