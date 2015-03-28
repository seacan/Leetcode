/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode runner = head;
        while (runner != null) {
            RandomListNode next = new RandomListNode(runner.label);
            next.next = runner.next;
            runner.next = next;
            runner = next.next;
        }

        runner = head;
        RandomListNode next = head.next;
        while (true) {
            next.random = runner.random == null ? null : runner.random.next;
            runner = runner.next.next;
            if (runner == null) break;
            next = runner.next;
        }

        RandomListNode newhead = head.next;
        runner = newhead;
        while (true) {
            next = runner.next;
            if (next != null) {
                head.next = next;
                runner.next = next.next;
                head = next;
                runner = runner.next;
            } else {
                head.next = null;
                runner.next = null;
                break;
            }
        }

        return newhead;
    }
}