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

    private int helper(List<Integer> accounts) {
        if (accounts.isEmpty() || accounts.size() == 1) return 0;
        List<Integer> filtered = new LinkedList<>();
        for (Integer account : accounts)
            if (account != 0) filtered.add(account);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < filtered.size(); i++) {
            List<Integer> merged = new LinkedList<>(filtered);
            merged.set(i, filtered.get(i) + filtered.get(0));
            merged.remove(0);
            res = Math.min(res, helper2(merged) + 1);
        }
        return res;
    }

    private void helper2(List<Integer> accounts, int start, int cnt) {
        int n = accounts.size();
        while (start < n && accounts.get(start) == 0) start++;
        if (start == n) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = start + 1; i < n; i++) {
            if ((accounts.get(i) < 0 && accounts.get(start) > 0) || (accounts.get(i) > 0 && accounts.get(start) < 0)) {
                accounts.set(i, accounts.get(i) + accounts.get(start));
                helper(accounts, start + 1, cnt + 1);
                accounts.set(i, accounts.get(i) - accounts.get(start));
            }
        }
    }
}