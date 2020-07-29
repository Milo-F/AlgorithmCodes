/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length, i = -1;// 长度和左节点
        for (int j = 0; j < len; ++j) {
            if (nums[j] != val) {// 当前数字不是目标数字
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
// @lc code=end

