// Input: 2->1->3->5->6->4->7->NULL
// Output: 2->3->6->7->1->5->4->NULL
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even; 

            while (even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead; 
        }
        return head;
    }
}