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
        for (RandomListNode runner = head; runner != null; runner = runner.next.next) {
            RandomListNode copy = new RandomListNode(runner.label);
            copy.next = runner.next;
            runner.next = copy;
        }
        for (RandomListNode runner = head; runner != null; runner = runner.next.next)
            runner.next.random = runner.random == null ? null : runner.random.next;

        RandomListNode newHead = head.next, runner = newHead;
        while (true) {
            if (runner.next == null) {
                head.next = null;
                break;
            }
            head.next = runner.next;
            runner.next = runner.next.next;
            head = head.next;
            runner = runner.next;
        }

        return newHead;
    }
}