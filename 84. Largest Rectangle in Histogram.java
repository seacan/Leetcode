class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        st.push(-1);
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            while (st.peek() != -1 && h < heights[st.peek()])
                maxArea = Math.max(maxArea, heights[st.pop()] * (i - 1 - st.peek()));
            st.push(i);
        }
        return maxArea;
    }
}