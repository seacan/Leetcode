public int FindNthNumber(int[] num, int start, int end, int rank) {
    int pivot = num[end];
    int right = end - 1;
    for (int i = start; i <= right; i++) {
        if (num[i] > pivot) {
            int temp = num[right];
            num[right--] = num[i];
            num[i--] = temp;
        }
    }
    right++;
    int temp = num[end];
    num[end] = num[right];
    num[right] = temp;
    if (right == start + rank - 1) return num[right];
    else if (right > start + rank - 1) return FindNthNumber(num, start, right - 1, rank);
    else return FindNthNumber(num, right + 1, end, rank - (right - start + 1));
}