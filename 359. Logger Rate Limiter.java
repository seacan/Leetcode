class Logger {
    class TimedMessage {
        public int timestamp;
        public String message;

        public TimedMessage(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    Queue<TimedMessage> queue;
    Set<String> messages;

    public Logger() {
        queue = new LinkedList<TimedMessage>();
        messages = new HashSet<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10) {
            String msg = queue.remove().message;
            messages.remove(msg);
        }
        if (messages.contains(message)) return false;
        else {
            queue.offer(new TimedMessage(timestamp, message));
            messages.add(message);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */