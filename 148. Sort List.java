public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), runner = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if (l1 == null) runner.next = l2;
        if (l2 == null) runner.next = l1;
        return res.next;
    }
}