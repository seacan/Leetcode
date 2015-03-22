public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null) {
            ListNode runner = cur;
            while (runner.next != null && runner.next.val == runner.val)
                runner = runner.next;
            cur.next = runner.next;
            cur = cur.next;
        }
        return head;
    }
}