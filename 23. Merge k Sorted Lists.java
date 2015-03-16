public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) return 1;
                else if (o1.val < o2.val) return -1;
                else return 0;
            }
        });

        ListNode pre = new ListNode(0);
        ListNode runner = pre;
        for (ListNode l : lists)
            if (l != null)
                q.offer(l);

        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            runner.next = cur;
            runner = runner.next;
            if (cur.next != null)
                q.offer(cur.next);
        }
        return pre.next;
    }
}