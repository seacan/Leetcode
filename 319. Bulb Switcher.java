// Input: 3
// Output: 1 
// Explanation: 
// At first, the three bulbs are [off, off, off].
// After first round, the three bulbs are [on, on, on].
// After second round, the three bulbs are [on, off, on].
// After third round, the three bulbs are [on, off, off]. 
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}