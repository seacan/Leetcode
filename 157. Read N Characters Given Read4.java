/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        char[] buffer = new char[4];
        boolean endOfFile = false;
        int cur = 0;

        while (cur < n && !endOfFile) {
            int buffCnt = read4(buffer);
            if (buffCnt < 4) endOfFile = true;            
            int bufferPtr = 0;
            while (cur < n && buffPtr < buffCnt)
               buf[cur++] = buff[buffPtr++];                      
        }
        return cur;
    }
}