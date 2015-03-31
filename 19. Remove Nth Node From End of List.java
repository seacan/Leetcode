public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // handle this special case
        if (head == null||(head.next == null && n == 1)) return null;
        ListNode front = head;
        while (n > 0) {
            // valiad case: when front stops at last null position
            if (front == null) return head;
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