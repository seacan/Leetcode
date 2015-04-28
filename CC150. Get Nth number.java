public int FindNthNumber(int[] num, int start, int end, int rank) {
    int pivot = num[end];
    int left = 0, right = end - 1;
    for (int i = start; i <= right; i++) {
        if (num[i] <= pivot) left++;
        else {
            int temp = num[right];
            num[right--] = num[i];
            num[i--] = temp;
        }
    }
    int temp = num[end];
    num[end] = num[left];
    num[left] = temp;
    if (left == rank - 1) return num[left];
    else if (left > rank - 1) return FindNthNumber(num, start, left - 1, rank);
    else return FindNthNumber(num, left + 1, end, rank - left - start - 1);
}