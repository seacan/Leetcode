public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int index = A.length - 1;
        // check <= index
        for (int i = 0; i <= index; i++)
            if (A[i] == elem)
                A[i--] = A[index--];
        // return index+1
        return index + 1;
    }
}