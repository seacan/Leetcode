public class Solution {
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
}