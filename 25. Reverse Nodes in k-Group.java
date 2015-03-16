public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode runner = pre;
        while (runner != null) {
            ListNode curRunner = runner;
            for (int i = 0; i < k; i++) {
                curRunner = curRunner.next;
                if (curRunner == null) return pre.next;
            }
            // reverse function call returns next pre
            runner = reverse(runner, k);
        }
        return pre.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode front = head.next, first = front, second = first.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        head.next = first;
        front.next = second;
        return front;
    }
}