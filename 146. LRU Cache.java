public class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        public Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    private class DoubleLinkedList {
        Node head, tail;
        int capacity, count;

        public DoubleLinkedList(int _capacity) {
            this.capacity = _capacity;
            this.count = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
    }

    private DoubleLinkedList list;
    private HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        list = new DoubleLinkedList(capacity);
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node.prev != list.head){
                remove(node);
                attachToFront(node);
            }
            return node.value;

        } else
            return -1;
    }

    public void set(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            if (node.prev != list.head) {
                remove(node);
                attachToFront(node);
            }
        } else {
            node = new Node(key, value);
            if (list.count != list.capacity) {
                list.count++;
            } else {
                map.remove(list.tail.prev.key); // remove key, not node
                remove(list.tail.prev);
            }
            attachToFront(node);
            map.put(key, node);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void attachToFront(Node node) {
        node.prev = list.head;
        node.next = list.head.next;
        list.head.next.prev = node;
        list.head.next = node;
    }
}