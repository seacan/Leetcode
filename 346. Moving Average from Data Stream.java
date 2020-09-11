class MovingAverage {
    private int size;
    private double sum;
    private LinkedList<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
    }

    double next(int val) {
        if (queue.size() >= size)
            sum -= queue.peekFirst();
        queue.addLast(val);
        sum += val;
        return sum / queue.size();
    }
}