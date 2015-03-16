public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode runner = pre;
        runner.next = head;
        ListNode first = head, second = head.next;
        while (second != null) {
            first.next = second.next;
            runner.next = second;
            second.next = first;
            runner = first;
            first = runner == null ? null : runner.next;
            second = first == null ? null : first.next;
        }
        return pre.next;
    }
}