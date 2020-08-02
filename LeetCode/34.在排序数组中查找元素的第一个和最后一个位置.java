/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = {-1, -1};
        if (nums == null || len == 0 || (len > 0 && (target > nums[len - 1] || target < nums[0]))) return result;
        int l = 0, r = len - 1, index = 0;
        while (r >= l) {
            index = (r + l) >> 1;
            // if (nums[l] == target) {
            //     index = l;
            //     break;
            // }
            // if (nums[r] == target) {
            //     index = r;
            //     break;
            // }
            if (target == nums[index]) {
                break;
            } else if(target > nums[index]) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        if (target == nums[index]) {
            l = index - 1;
            r = index + 1;
            while (l > -1 && nums[l] == target) --l;
            while (r < len && nums[r] == target) ++r;
            result[0] = l + 1;
            result[1] = r - 1;
        }
        return result;
    }
}
// @lc code=end

