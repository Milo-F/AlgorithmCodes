/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>(0);
        if (len == 0 || candidates == null) return result;
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        findNumbers(candidates, target, result, item, 0);
        return result;
    }
    public void findNumbers(int[] nums, int target, List<List<Integer>> list, List<Integer> item, int beginIndex) {
        int newTarget = 0;
        for (int i = beginIndex; i < nums.length; ++i) {
            newTarget = target - nums[i];
            if (newTarget > 0) {
                item.add(nums[i]);
                findNumbers(nums, newTarget, list, item, i);
                item.remove(item.size() - 1);
            } else if (newTarget < 0) {
                break;
            } else {
                item.add(nums[i]);
                list.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                break;
            }
        }
    }
}
// @lc code=end

