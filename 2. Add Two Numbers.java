public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	return addTwoNumbersHelper(l1, l2, 0);
    }
    
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int pad) {
    	if (l1 == null && l2 == null && pad == 0) return null;
    	int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + pad;
    	ListNode head = new ListNode(val % 10);
    	// check if current pointer is null
    	head.next = addTwoNumbersHelper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
    	return head;
    }
}