class MaxStack {
    public MaxStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void push(int x) {
        if (s2.isEmpty() || s2.peek() <= x) s2.push(x);
        s1.push(x);
    }

    int pop() {
        if (!s2.isEmpty() && s2.peek() == s1.peek()) s2.pop();
        return s1.pop();
    }

    int top() {
        return s1.peek();
    }

    int peekMax() {
        return s2.peek();
    }

    int popMax() {
        int mx = s2.peek();
        Stack<Integer> t = new Stack<>();
        while (s1.peek() != s2.peek())
            t.push(s1.pop());
        s1.pop();
        s2.pop();
        while (!t.isEmpty())
            push(t.pop());
        return mx;
    }

    private Stack<Integer> s1, s2;
}