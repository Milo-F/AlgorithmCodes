/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>(0);
        if (len == 0 || candidates == null) return result;
        List<Integer> numList = new ArrayList<>();
        findNums(result, numList, candidates, -1, target);
        return result;
    }
    public void findNums(List<List<Integer>> result, List<Integer> numList, int[] nums, int beginInedx, int target) {
        int newTarget = 0;
        for (int i = beginInedx + 1; i < nums.length; ++i) {
            // why?为什么这句会起到去重的作用
            // 
            if (i > beginInedx + 1 && nums[i] == nums[i - 1]) continue;// 去重
            newTarget = target - nums[i];
            if (newTarget == 0) {
                // 结果处理
                numList.add(nums[i]);
                result.add(new ArrayList<>(numList));
                numList.remove(numList.size() - 1);
            } else if (newTarget > 0) {
                // 递归
                numList.add(nums[i]);
                findNums(result, numList, nums, i, newTarget);
                numList.remove(numList.size() - 1);
            }
        }
        
    }
}
// @lc code=end

