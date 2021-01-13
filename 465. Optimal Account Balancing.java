class Solution {
    public int minTransfers(List<int[]> transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        List<Integer> accounts = new LinkedList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet())
            if (m.getValue() != 0)
                accounts.add(m.getValue());

        return helper(accounts);
    }

    // Returns min transaction count.
    public static int helper(List<Integer> accounts) {
        int cur = 0;
        while (cur < accounts.size() && accounts.get(cur) == 0) cur++;
        if (cur == accounts.size()) return 0;

        int balance = accounts.get(cur);
        int res = Integer.MAX_VALUE;
        for (int i = cur + 1; i < accounts.size(); i++) {
            if (accounts.get(i) != 0) {
                accounts.set(cur, 0);
                accounts.set(i, accounts.get(i) + balance);
                res = Math.min(res, helper(accounts) + 1);
                accounts.set(cur, balance);
                accounts.set(i, accounts.get(i) - balance);
            }
        }
        return res;
    }

    // Returns detailed transactions.
    public static List<List<Integer>> helper(List<Integer> accounts) {
        List<List<Integer>> res = new ArrayList<>();
        int cur = 0;
        while (cur < accounts.size() && accounts.get(cur) == 0) cur++;
        if (cur == accounts.size()) return res;

        int balance = accounts.get(cur);
        int max = Integer.MAX_VALUE;
        for (int i = cur + 1; i < accounts.size(); i++) {
            if (accounts.get(i) != 0) {
                accounts.set(cur, 0);
                accounts.set(i, accounts.get(i) + balance);
                List<List<Integer>> remaining = helper(accounts);
                if (remaining.size() + 1 < max) {
                    max = remaining.size() + 1;
                    res.clear();
                    res.addAll(remaining);
                    res.add(0, Arrays.asList(cur, i, balance));
                }
                accounts.set(cur, balance);
                accounts.set(i, accounts.get(i) - balance);
            }
        }
        return res;
    }
}