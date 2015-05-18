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