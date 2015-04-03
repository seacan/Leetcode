// Solution 1. Only swap when i is not equal to position of l or r
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int l = 0, r = A.length - 1;
        // l must be less than r, also should not move beyond r
        for (int i = 0; i <= r && l < r;)
            // only swap when i not equals to position of l or r
            if (A[i] == 0 && i != l) {
                A[i] = A[l];
                A[l++] = 0;
            } else if (A[i] == 2 && i != r) {
                A[i] = A[r];
                A[r--] = 2;
            } else
                i++;
    }
}


// Solution 2. Move l and r pointer when current i is equal to 0 or 2
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int l = 0, r = A.length - 1;
        for (int i = 0; i <= r && l < r; i++)
            if (A[i] == 0) {
                if(i != l){
                    A[i--] = A[l];
                    A[l++] = 0;
                } else
                    l++;
            } else if (A[i] == 2) {
                if (i != r){
                    A[i--] = A[r];
                    A[r--] = 2;
                }
                else 
                    r--;
            }
                
    }
}