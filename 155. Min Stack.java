class MinStack {
    private long min;
    private Stack<Long> stack = new Stack<Long>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.empty()) return;
        long pop = stack.pop();
        if (pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        return top > 0 ? (int) (min + top) : (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}
