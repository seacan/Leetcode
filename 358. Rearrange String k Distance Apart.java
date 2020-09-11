class Pair {
    char ch;
    int count;

    public Pair(int count, int ch) {
        this.count = count;
        this.ch = ch;
    }
}

class Main {
    public String rearrangeString(String str, int k) {
        if (k == 0) return str;
        StringBuilder res = new StringBuilder();
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair> queue = new PriorityQueue<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (Map.Entry e : map.entrySet()) queue.offer(new Pair(e.getValue(), e.getKey()));
        while (!queue.isEmpty()) {
            Queue<Pair> local = new PriorityQueue<>();
            vector<pair<int, int>> v;
            int cnt = Math.min(k, len);
            for (int i = 0; i < cnt; ++i) {
                if (queue.isEmpty()) return "";
                Pair t = queue.poll();
                res.append(t.ch);
                if (--t.count > 0) local.offer(t);
                --len;
            }
            queue.addAll(local);
        }
        return res;
    }
}