public class Solution {
    public int maxArea(int[] height) {
        int vol = 0, l = 0, r = height.length - 1;
    	while (l < r) {
    		vol = Math.max(vol, (r - l) * Math.min(height[l], height[r]));
    		if (height[l] < height[r]) l++;
    		else r--;
    	}
    	return vol;
    }
}