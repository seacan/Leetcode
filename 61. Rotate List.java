public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = 0;
        ListNode runner = head;
        while(k>0) {
            k--;
            runner = runner.next;
            length++;
            if (runner == null) {
                k = k % length;
                runner = head;
            }
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