class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int len = A.length;      
        while(len>1) {
            int max = A[0], index=0;
            //find the index of the max element in current unsorted part of the array; up to len
            for(int i=0; i<len; i++)
                if(A[i]>max) {
                    max = A[i];
                    index = i;
                }            
            
            //if max is at last position, no need to do any flips
            if(index==len-1) {
                len--;
                continue;
            }
                        
            result.add(index+1);
            reverse(A, index+1);            
            result.add(len);
            reverse(A, len);
            len--;    
        }
        
        return result;
    }
    
    public void reverse(int[] A, int len) {
        int left=0, right=len-1;
        while(left<right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }
}