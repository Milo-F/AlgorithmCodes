/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;// 给定的数组长度
        List<List<Integer>> result = new ArrayList<>(0);// 返回结果的list
        if (len == 0 || candidates == null) return result;// 当数组为空时的特殊判定
        Arrays.sort(candidates);// 排序，从最小的开始计算，方便去重，因为越小的数字其可能的目标组合越多
        List<Integer> item = new ArrayList<>();// 存放可能组合的list
        findNumbers(candidates, target, result, item, 0);// 寻找可能的数字组合函数
        return result;// 返回结果
    }
    /**
     * 主要函数，参数包括：
     * @param nums 给定数组
     * @param target 目标值
     * @param list 结果列表
     * @param item 可能的数字组合
     * @param beginIndex 检索的起始位置，用于去重防止重复检索
     */
    public void findNumbers(int[] nums, int target, List<List<Integer>> list, List<Integer> item, int beginIndex) {
        int newTarget = 0;// 新目标值，用于每次递归保存新target，递归时作为参数传入
        for (int i = beginIndex; i < nums.length; ++i) {// 循环遍历给定数组，从起始beginIndex开始遍历
            newTarget = target - nums[i];// 计算新的目标值
            if (newTarget > 0) {// 若新目标值大于0，则进行递归
                item.add(nums[i]);// 将当前值保存
                findNumbers(nums, newTarget, list, item, i);// 递归
                item.remove(item.size() - 1);// 移除当前值，方便循环的下一个值的保存判断（若不移除将导致值的叠加）
            } else if (newTarget < 0) {// 若新目标值小于0则跳出递归
                break;
            } else {// 若目标值等于0，说明找到了一种数字组合以达到target，将结果保存至list
                item.add(nums[i]);
                list.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                break;
            }
        }
    }
}
// @lc code=end

