public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode runner = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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
        return pre.next;
    }
}