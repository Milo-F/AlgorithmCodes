/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length, temp = 0;
        boolean swap = false;// 是否交换重排序
        // 从后往前遍历
        for (int i = len - 2; i > -1 && !swap && len > 1; --i) {
            swap = (nums[i] >= nums[i + 1]) ? false : true;// 如果当前数字小于后一数字，说明存在下一排序
            if (swap) {// 若存在下一排序，交换重排
                if (nums[len - 1] > nums[i]) {// 若最后一个数字（即暂时最小的数字）仍大于当前数字，直接交换后部分升序排序
                    temp = nums[i];
                    nums[i] = nums[len - 1];
                    nums[len - 1] = temp;
                    Arrays.sort(nums, i + 1, len);
                } else {// 若最后一个数字比当前数字小，则在遍历过的数字中找一个大于当前数字的最小数字交换重排
                    for (int j = i + 1; j < len - 1; ++j) {
                        if (nums[j] > nums[i] && nums[j + 1] <= nums[i]) {
                            temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            Arrays.sort(nums, i + 1, len);
                        }
                    }
                } 
            }
            if (i == 0 && !swap) Arrays.sort(nums);// 若数组是倒序，则重排升序
        }
    }
}
// @lc code=end

