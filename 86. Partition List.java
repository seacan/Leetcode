public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0), r = new ListNode(0), lpre = l, rpre = r;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        if (lpre.next == null) return rpre.next;
        l.next = rpre.next;
        // set last r point to null, otherwise it could be a circular list
        r.next = null;
        return lpre.next;
    }
}