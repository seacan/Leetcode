class Solution {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;
        int found = s.indexOf('(');
        int val = (found == -1) ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, found));
        TreeNode cur = new TreeNode(val);
        if (found == -1) return cur;
        int start = found, cnt = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') ++cnt;
            else if (s.charAt(i) == ')') --cnt;
            if (cnt == 0 && start == found) {
                cur.left = str2tree(s.substring(start + 1, i - start - 1));
                start = i + 1;
            } else if (cnt == 0) {
                cur.right = str2tree(s.substring(start + 1, i - start - 1));
            }
        }
        return cur;
    }
}