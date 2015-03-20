public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = 0;
        ListNode runner = head;
        while (runner != null && k > 0) {
            runner = runner.next;
            length++;
            k--;
        }
        if (runner == null) {
            if (k == 0) return head;
            k = k % length;
            runner = head;
            for (; k > 0; k--)
                runner = runner.next;
        }
        
        // handle this special case, when nothing needs to rotate
        if(runner == head) return head;

        ListNode back = head;
        while (runner.next != null) {
            back = back.next;
            runner = runner.next;
        }
        ListNode newhead = back.next;
        back.next = null;
        runner.next = head;
        return newhead;
    }
}