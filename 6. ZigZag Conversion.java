public class Solution {
    // Solution 1. use the incremental value to control the direction.
    public String convert(String s, int nRows) {
        // if nRow is 1, return here, otherwise +1/-1 change will fail
        if (s == null || s.length() == 0 || nRows == 1) return s;
        StringBuffer[] buffers = new StringBuffer[nRows];
        // need to initialize all element in array
        for (int i = 0; i < buffers.length; i++) buffers[i] = new StringBuffer();
        int bufferIndex = 0, nextBuffer = 1;
        for (int i = 0; i < s.length(); i++) {            
            if (bufferIndex == nRows - 1)
                nextBuffer = -1;
            if (bufferIndex == 0)
                nextBuffer = 1;
            buffers[bufferIndex].append(s.charAt(i));
            bufferIndex += nextBuffer;
        }
        for (int i = 1; i < buffers.length; i++)
            buffers[0].append(buffers[i]);
        return buffers[0].toString();
    }

    // Solution 2. use the for loop to control the direction.
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            for (int row = 0; row < numRows && i < s.length(); row++)
                sbs[row].append(s.charAt(i++));
            for (int row = numRows - 2; row >= 1 && i < s.length(); row--)
                sbs[row].append(s.charAt(i++));
        }
        for (int i = 1; i < numRows; i++) sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }
}