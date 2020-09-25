class Tracker {
    String str;
    List<String> sol;

    public Tracker(String str) {
        this.str = str;
        sol = new ArrayList<>();
        sol.add(str);
    }
}

class Solution {
    private List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        if (dict.size() == 0) return res;

        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> ladder = new HashMap<String, Integer>();
        for (String s : dict) ladder.put(s, Integer.MAX_VALUE);
        ladder.put(start, 0);

        Queue<Tracker> queue = new LinkedList<>();
        queue.add(new Tracker(start));
        while (!queue.isEmpty()) {
            Tracker cur = queue.poll();
            int step = ladder.get(cur.str) + 1;
            if (step > min) break;

            for (int i = 0; i < cur.str.length(); i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    String newString = cur.str.substring(0, i) + c + cur.str.substring(i + 1);
                    if (ladder.containsKey(newString)) {
                        if (step > ladder.get(newString)) continue;
                        if (step <= ladder.get(newString)) {
                            Tracker newTracker = new Tracker(newString);
                            newTracker.sol = new ArrayList<>(cur.sol);
                            newTracker.sol.add(newString);
                            queue.add(newTracker);
                            ladder.put(newString, step);
                        }

                        if (newString.equals(end)) {
                            min = step;
                            cur.sol.add(end);
                            res.add(cur.sol);
                        }
                    }
                }
        }
        return res;
    }
}