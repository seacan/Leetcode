// Solution 1: recursive one based on n-1 result
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        return permuteHelper(num, num.length - 1);
    }

    private List<List<Integer>> permuteHelper(int[] num, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == 0) {
            res.add(new ArrayList<Integer>(Arrays.asList(num[index])));
            return res;
        }

        List<List<Integer>> pre = permuteHelper(num, index - 1);
        for (List<Integer> sol : pre) {
            for (int i = 0; i < sol.size() + 1; i++) {
                List<Integer> copy = new ArrayList<Integer>(sol);
                copy.add(i, num[index]);
                res.add(copy);
            }
        }
        return res;
    }
}

// Solution 2: backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}