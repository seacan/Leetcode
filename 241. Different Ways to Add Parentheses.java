public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+')
                for (int p1 : diffWaysToCompute(input.substring(0, i)))
                    for (int p2 : diffWaysToCompute(input.substring(i + 1)))
                        switch (input.charAt(i)) {
                            case '+':
                                res.add(p1 + p2);
                                break;
                            case '-':
                                res.add(p1 - p2);
                                break;
                            case '*':
                                res.add(p1 * p2);
                                break;
                        }
        if (res.size() == 0) res.add(Integer.parseInt(input));
        return res;
    }
}