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
        ListNode front = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode cur = front.next;
            front.next = cur.next;
            cur.next = head.next;
            head.next = cur;
        }
        return front;
    }
}