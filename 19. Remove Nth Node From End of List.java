public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // handle this special case
        if (head == null||(head.next == null && n == 1)) return null;
        ListNode front = head;
        for (; n > 0; n--){
            // valiad case: when front stops at last null position
            if (front == null) return head;
            front = front.next;
        }

        // hanle deleting head case
        if (front == null) return head.next;
        ListNode back = head;
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}