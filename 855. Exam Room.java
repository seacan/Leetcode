// When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
// If there are multiple such seats, they sit in the seat with the lowest number. 
class ExamRoom {

    private int N;
    private ArrayList<Integer> L;
    
    public ExamRoom(int n) {
        this.N = n;
        this.L = new ArrayList<>();
    }

    public int seat() {
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        // Get front and back empty length.
        int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
        // Get intermediate empty length.
        for (int i = 0; i < L.size() - 1; ++i) d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
        // Insert to front.
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        // Insert to middle.
        for (int i = 0; i < L.size() - 1; ++i)
            if ((L.get(i + 1) - L.get(i)) / 2 == d) {
                L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
                return L.get(i + 1);
            }
        // Insert to back.
        L.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < L.size(); ++i) if (L.get(i) == p) L.remove(i);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */