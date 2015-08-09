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


public int ladderLength(String start, String end, Set<String> dict) {
    Queue<String> worldQueue = new LinkedList<String>();
    Queue<Integer> lengthQueue = new LinkedList<Integer>();
    worldQueue.add(start);
    lengthQueue.add(1);
    while (!worldQueue.isEmpty()) {
        String cur = worldQueue.poll();
        int len = lengthQueue.poll();
        if (cur.equals(end)) return len;

        for (int i = 0; i < cur.length(); i++)
            for (char c = 'a'; c <= 'z'; c++) {
                String newString = cur.substring(0, i) + c + cur.substring(i + 1);
                if (dict.contains(newString)) {
                    dict.remove(newString);
                    worldQueue.offer(newString);
                    lengthQueue.offer(len + 1);
                }
            }
    }
    return 0;
}


public int ladderLength(String start, String end, Set<String> dict) {
    Queue<String> queue = new LinkedList<String>();
    queue.add(start);
    queue.add(null);

    Set<String> visited = new HashSet<String>();
    visited.add(start);

    int level = 1;
    while (!queue.isEmpty()) {
        String cur = queue.poll();
        if (cur != null) {
            for (int i = 0; i < cur.length(); i++)
                for (char c = 'a'; c <= 'z'; c++) {
                    String newString = cur.substring(0, i) + c + cur.substring(i + 1);
                    if (newString.equals(end)) return level + 1;
                    if (dict.contains(newString) && !visited.contains(newString)) {
                        queue.add(newString);
                        visited.add(newString);
                    }
                }
        } else {
            level++;
            if (!queue.isEmpty()) queue.add(null);
        }
    }

    return 0;
}