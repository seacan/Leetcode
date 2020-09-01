public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode runner = pre;
        runner.next = head;
        while (runner.next != null && runner.next.next != null) {
            ListNode first = runner.next, second = first.next;
            first.next = second.next;
            second.next = first;
            runner.next = second;
            runner = first;
        }
        return pre.next;
    }
}