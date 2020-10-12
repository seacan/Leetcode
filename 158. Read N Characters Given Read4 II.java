// Given a file and assume that you can only read the file using a given method read4, implement a method read to read  n  characters.
// Your method read may be called multiple times.
// File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
// char[] buf = new char[4]; // Create buffer with enough space to store characters
// read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
// read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
// read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
public class Solution extends Reader4 {
   private int buffPtr = 0;
   private int buffCnt = 0;
   private char[] buff = new char[4];
   public int read(char[] buf, int n) {
      int cur = 0;
      while (cur < n) {
         if (buffPtr == 0) buffCnt = read4(buff);
         if (buffCnt == 0) break;
         while (cur < n && buffPtr < buffCnt)
            buf[cur++] = buff[buffPtr++];
         if (buffPtr >= buffCnt) buffPtr = 0;
      }
      return cur;
   }
}