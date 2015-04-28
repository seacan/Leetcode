public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (ListNode runner = pre; runner != null;)
            if (runner.next != null && runner.next.val == val)
                runner.next = runner.next.next;
            else
                runner = runner.next;
        return pre.next;
    }
}