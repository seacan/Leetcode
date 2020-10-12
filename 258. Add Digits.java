// Input: 38
// Output: 2 
// Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
//              Since 2 has only one digit, return it.
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}