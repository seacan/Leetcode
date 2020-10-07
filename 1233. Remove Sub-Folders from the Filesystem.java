// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]
// Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        LinkedList<String> ans = new LinkedList<>();
        Arrays.sort(folder);
        for (String f : folder)
            if (ans.isEmpty() || !f.startsWith(ans.peekLast() + '/'))
                ans.offer(f);
        return ans;
    }
}