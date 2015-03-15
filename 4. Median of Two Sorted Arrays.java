public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
    	int totalLength = A.length + B.length;
    	if (totalLength % 2 == 1) {
    		return findRankSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, totalLength / 2);
    	} else {
    		return (findRankSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, totalLength / 2) +
    				findRankSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, totalLength / 2 - 1)) / 2;
    	}
    }
    
    private double findRankSortedArrays(int[] A, int startA, int endA, int[] B, int startB, int endB, int rank) {
    	if (startA > endA) return B[startB + rank];
    	if (startB > endB) return A[startA + rank];
    
    	int midA = (startA + endA) / 2, midB = (startB + endB) / 2;
    	if (A[midA] <= B[midB])
    	    // if rank is in the first half of 2 arrays
    	    if (rank <= (midA - startA) + (midB - startB))
    	        return findRankSortedArrays(A, startA, endA, B, startB, midB - 1, rank);
	    else
	        return findRankSortedArrays(A, midA + 1, endA, B, startB, endB, rank - (midA - startA + 1));
    	else if (rank <= (midA - startA) + (midB - startB))
    		return findRankSortedArrays(A, startA, midA - 1, B, startB, endB, rank);
    	else
    		return findRankSortedArrays(A, startA, endA, B, midB + 1, endB, rank - (midB - startB + 1));
    }
}