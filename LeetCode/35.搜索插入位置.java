/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length, result = 0;
        int l = 0, r = len - 1, mid = 0;
        while (r >= l) {
            mid = (l + r) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return target > nums[mid] ? mid + 1 : mid;
    }
}
// @lc code=end

