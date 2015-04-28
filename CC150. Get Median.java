private Queue<Integer> minHeap = new PriorityQueue<Integer>();
private Queue<Integer> maxHeap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
public void Insert(int value) {
    if (maxHeap.size() == minHeap.size()) {
        if (!minHeap.isEmpty() && value > minHeap.peek()) {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(value);
        } else
            maxHeap.offer(value);
    } else {
        if (value < maxHeap.peek()) {
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(value);
        } else
            minHeap.offer(value);
    }
}

public int GetMedian() {
    if (maxHeap.size() == 0) return 0;
    if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2;
    else return maxHeap.peek();
}