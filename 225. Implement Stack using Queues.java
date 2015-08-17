class MyStack {
    private Deque<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.pollLast();
    }

    // Get the top element.
    public int top() {
        return queue.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}