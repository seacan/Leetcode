// Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
// Output: 32
// Explanation: We have two files:
// "dir/subdir1/file1.ext" of length 21
// "dir/subdir2/subsubdir2/file2.ext" of length 32.
class Solution {
    public int lengthLongestPath(String input) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 1;
            int len = s.length() - level;
            while (stack.size() > level + 1)
                stack.pop();            
            if (s.contains(".")) result = Math.max(result, stack.peek() + len);
            else stack.push(stack.peek() + len + 1);            
        }
        return result;
    }
}