/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int capacity = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                capacity = Math.max(capacity, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return capacity;
    }
}
// @lc code=end

