public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        while (head != null) {
            ListNode next = head.next, runner = res;
            while(runner.next != null && head.val > runner.next.val)
                runner = runner.next;
            head.next = runner.next;
            runner.next = head;
            head = next;
        }
        return res.next;
    }
}