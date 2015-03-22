public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode cur = pre, runner = head;
        while (runner != null) {
            while (runner.next != null && runner.next.val == runner.val)
                runner = runner.next;
            // forward cur only when next node is not duplicated
            if (runner == cur.next) cur = cur.next;
            else cur.next = runner.next;
            runner = runner.next;
        }
        return pre.next;
    }
}