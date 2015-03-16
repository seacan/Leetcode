public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        // handle this special case
        if (head.next == null && n == 1) return null;
        ListNode front = head;
        while (n > 0) {
            if (front == null && n > 0) return head;
            front = front.next;
            n--;
        }

        // hanle deleting head case
        if (front == null) return head.next;
        ListNode back = head, pre = head;
        while (front != null) {
            front = front.next;
            pre = back;
            back = back.next;
        }
        pre.next = back.next;
        return head;
    }
}