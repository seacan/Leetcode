public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0), runner = pre;
        pre.next = head;
        while (runner.next != null) {
            if (runner.next.val == val) runner.next = runner.next.next;
            else runner = runner.next;
        }
        return pre.next;
    }
}