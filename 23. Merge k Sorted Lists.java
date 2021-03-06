public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length, Comparator.comparingInt(a -> a.val));

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