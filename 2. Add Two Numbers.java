public class Solution {
    // Solution 1: add with recursion
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

    // Solution 2: add in loop
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), runner = res;
        int add = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            runner.next = new ListNode(sum % 10);
            runner = runner.next;
            add = sum / 10;
        }
        if (add != 0) {
            runner.next = new ListNode(add);
            runner = runner.next;
        }
        return res.next;
    }
}