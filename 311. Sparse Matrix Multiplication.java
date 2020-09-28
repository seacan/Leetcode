// Mattirx mutiplication
class Solution {
    public List<List<Integer>> multiply(List<List<Integer>> A, List<List<Integer>> B) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < A.get(0).size(); j++) {
                int sum = 0;
                for (int k = 0; k < A.get(0).size(); k++)
                    sum += A.get(i).get(k) * B.get(k).get(j);
                res.get(i).add(sum);
            }
        }
        return res;
    }
}