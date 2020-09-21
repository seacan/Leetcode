class Solution {
    public List<String> removeSubfolders(String[] folder) {
        LinkedList<String> ans = new LinkedList<>();
        Arrays.sort(folder);
        for (String f : folder)
            if (ans.isEmpty() || !f.startsWith(ans.peekLast() + '/')) //  need '/' to ensure a parent.
                ans.offer(f);
        return ans;
    }
}