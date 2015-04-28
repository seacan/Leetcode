// solution 1. use HashSet to track numbers
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<Integer>();
        while (!sets.contains(n)) {
            sets.add(n);
            int next = 0;
            while (n > 0) {
                next += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (next == 1) return true;
            n = next;
        }
        return false;
    }
}



// solution 2. borrow the idea from cycle linkedlist
public class Solution {
    public boolean isHappy(int n) {
        int slow = next(n), fast = next(slow);
        while (slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return slow == 1;
    }

    private int next(int n){
        int next = 0;
        while (n > 0) {
            next += Math.pow(n % 10, 2);
            n /= 10;
        }
        return next;
    }
}