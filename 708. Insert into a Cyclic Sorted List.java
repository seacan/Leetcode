class Solution {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode pre = head, cur = pre.next;
        while (cur != head) {
            if (pre.val <= insertVal && cur.val >= insertVal) break;
            if (pre.val > cur.val && (pre.val <= insertVal || cur.val >= insertVal)) break;
            pre = cur;
            cur = cur.next;
        }
        pre.next = new ListNode(insertVal, cur);
        return head;
    }
}