public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead, runner = head;
        for (int i = 1; i < m; i++) {
            pre = runner;
            runner = runner.next;
        }

        ListNode front = runner, next = runner.next;
        for (int i = m; i < n; i++) {
            ListNode temp = next.next;
            next.next = runner;
            runner = next;
            next = temp;
        }
        pre.next = runner;
        front.next = next;
        return newhead.next;
    }
}