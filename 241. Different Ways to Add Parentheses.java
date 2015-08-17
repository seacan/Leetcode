public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+')
                for (Integer p1 : diffWaysToCompute(input.substring(0, i)))
                    for (Integer p2 : diffWaysToCompute(input.substring(i + 1))) {
                        int total = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                total = p1 + p2;
                                break;
                            case '-':
                                total = p1 - p2;
                                break;
                            case '*':
                                total = p1 * p2;
                                break;
                        }
                        res.add(total);
                    }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}