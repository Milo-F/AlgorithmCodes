/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int len = nums.length;
        int maxDistance, location = 0, i = 0;
        while (i + nums[i] < len && nums[i] != 0) {
            maxDistance = 0;
            for (int j = i + 1; j <= i + nums[i]; ++j) {
                if (maxDistance < nums[j] + j) {
                    maxDistance = nums[j] + j;
                    location = j;
                }
            }
            i = location;
        }
        return nums[i] == 0 && i != len - 1 ? false : true;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int currentPower = nums[0];
        if(nums[0]==0 && nums.length != 1){
            return false;
        }
        for (int a = 1; a < nums.length; a++) {
            currentPower--;
            if (nums[a] < currentPower) {
                continue;
            } else {
                currentPower = nums[a];
            }
            if (currentPower == 0 && nums[a] == 0 && a != nums.length - 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

