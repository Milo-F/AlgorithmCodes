/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2 || null == nums) return 0;
        int len = nums.length;
        int location = 0, result = 0;
        while (location + nums[location] < len - 1) {
            int temp = 0, maxDistance = 0;
            for (int i = location + 1; i <= location + nums[location]; ++i) {
                if (i + nums[i] > maxDistance) {
                    maxDistance = i + nums[i];
                    temp = i;
                }
            }
            location = temp;
            ++result;
        }
        return result + 1;
    }
}
// @lc code=end

