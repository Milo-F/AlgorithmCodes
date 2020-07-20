/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length, result = 0;
        if (len < 3) return result;
        Arrays.sort(nums);
        int sum = 0, distance = 0, minDis = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; ++i) {           
            int j = i + 1, k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                distance = Math.abs(sum - target);
                if (distance < minDis) {
                    minDis = distance;
                    result = sum;
                } else if (sum - target < 0) {
                    // while (j + 1 < len - 1 && nums[j + 1] == nums[j]) 
                    ++j;
                } else {
                    // while (k > j && nums[k - 1] == nums[k]) 
                    --k;
                }
            }
        }
        return result;
    }
}
// @lc code=end

