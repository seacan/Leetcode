public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (st.peek() != -1 && height[i] < height[st.peek()])
                    max = Math.max(max, height[st.pop()] * (i - st.peek() - 1));
            st.push(i);
        }

        while (st.peek() != -1)
            max = Math.max(max, height[st.pop()] * (height.length - 1 - st.peek()));

        return max;
    }
}