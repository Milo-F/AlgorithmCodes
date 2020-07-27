/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int newLen = 0;
        int len = nums.length;
        for (; newLen < len; ) {
            if (newLen > 0 && nums[newLen - 1] == nums[newLen]) {
                for (int j = newLen + 1; j < nums.length; ++j) {
                    nums[j - 1] = nums[j];
                }
                --len;
            } else {
                ++newLen;
            }
        }
        return newLen;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 1; j < len; ++j) {
            if (nums[i] != nums[j]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
// @lc code=end

