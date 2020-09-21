class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) left++;
        if (left == arr.length - 1) return 0;
        while (right > 0 && arr[right] >= arr[right - 1]) right--;

        int min = arr[left], max = arr[right];
        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        while (left > 0 && arr[left - 1] > min) left--;
        while (right < arr.length - 1 && arr[right + 1] < max) right++;

        return right - left + 1;
    }
}