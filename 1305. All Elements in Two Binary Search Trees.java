class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        inorder(root1, list1);
        List<Integer> list2 = new ArrayList();
        inorder(root2, list2);
        return mergeList(list1, list2);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) list.add(list1.get(i++));
            else list.add(list2.get(j++));
        }

        while (i < list1.size()) list.add(list1.get(i++));
        while (j < list2.size()) list.add(list2.get(j++));

        return list;
    }
}