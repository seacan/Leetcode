class Solution {
    public int shortestWay(String source, String target) {
        int t = 0, res = 0;
        while (t < target.length()) {
            int start = t;
            for (int s = 0; s < source.length(); s++) 
                if (t < target.length() && target.charAt(t) == source.charAt(s))
                    t++;
            if (start == t) return -1;
            res++;
        }
        return res;
    }
}