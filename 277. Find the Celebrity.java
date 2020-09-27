//The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
public class Solution {
    bool knows(int a, int b);
    int findCelebrity(int n) {
        for (int i = 0, j = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                if (i != j && (knows(i, j) || !knows(j, i))) break;
            }
            if (j == n) return i;
        }
        return -1;
    }
}