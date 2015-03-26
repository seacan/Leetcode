public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        List<Integer> first = new ArrayList<Integer>(Arrays.asList(1));
        res.add(first);
        if (numRows == 1) return res;
        List<Integer> second = new ArrayList<Integer>(Arrays.asList(1, 1));
        res.add(second);
        if (numRows == 2) return res;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> newRow = new ArrayList<Integer>(Arrays.asList(1));
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 0; j < last.size() - 1; j++)
                newRow.add(last.get(j) + last.get(j + 1));
            newRow.add(1);
            res.add(newRow);
        }

        return res;
    }
}