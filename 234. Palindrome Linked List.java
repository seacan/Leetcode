// solution 1. recursive
public class Solution {
    public boolean isPalindrome(ListNode head) {
        return isPalindromeHelper(head, length(head));
    }

    private ListNode tail = null;
    private boolean isPalindromeHelper(ListNode head, int length) {
        if (length == 0 || length == 1) {
            tail = head;
            return true;
        }
        if (length == 2) {
            tail = head.next;
            return head.val == head.next.val;
        }

        if (isPalindromeHelper(head.next, length - 2) && head.val == tail.next.val) {
            tail = tail.next;
            return true;
        }
        return false;
    }

    private int length(ListNode head) {
        int len = 0;
        for (; head != null; head = head.next) len++;
        return len;
    }
}


//soluition 2. fast and slow pointer