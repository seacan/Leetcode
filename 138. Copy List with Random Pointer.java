/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// Solution 1: create the node copy next to each one
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

// Solution 2: easy to read with Map
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }   
}