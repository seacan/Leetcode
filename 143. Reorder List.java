public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode end = fast == null ? pre : slow;
        reverse(end);
        ListNode secondHead = end.next;
        end.next = null;
        Merge(head, secondHead);
    }

    private void reverse(ListNode head) {
        ListNode runner = head.next, front = head.next;
        while (runner.next != null) {
            ListNode next = runner.next;
            runner.next = next.next;
            next.next = front;
            head.next = next;
            front = next;
        }
    }

    private void Merge(ListNode h1, ListNode h2) {
        ListNode runner = h1;
        h1 = h1.next;
        boolean isH2 = true;
        while (true) {
            if (isH2) {
                runner.next = h2;
                if (h2 == null) break;
                h2 = h2.next;
            } else {
                runner.next = h1;
                if (h1 == null) break;
                h1 = h1.next;
            }
            runner = runner.next;
            isH2 = !isH2;
        }
    }
}