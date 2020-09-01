public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(), fast = preHead, slow = preHead;
        preHead.next = head;
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }
}