public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode cur = pre;
        while (cur != null) {
            ListNode next = cur.next, runner = cur.next;
            while (runner != null && runner.next != null && runner.next.val == runner.val)
                runner = runner.next;
            if (runner == next) cur = cur.next;
            else cur.next = runner.next;
        }
        return pre.next;
    }
}