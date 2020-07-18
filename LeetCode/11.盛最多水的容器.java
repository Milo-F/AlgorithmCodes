/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
// 暴力解法
// class Solution {
//     public int maxArea(int[] height) {
//         int len = height.length;
//         int capacity = 0;
//         for (int i = 0; i < len; ++i) {
//             for (int j = i + 1; j < len; ++j) {
//                 capacity = Math.max(capacity, Math.min(height[i], height[j]) * (j - i));
//             }
//         }
//         return capacity;
//     }
// }
// 双指针代表的是 可以作为容器边界的所有位置的范围
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int capacity = 0, width = 0;
        int leftPoint = 0, rightpoint = len - 1;
        boolean leftMove = false;
        while (rightpoint > leftPoint) {
            width = rightpoint - leftPoint;
            leftMove = (height[leftPoint] > height[rightpoint]) ? false : true;
            capacity = Math.max(capacity, Math.min(height[leftPoint], height[rightpoint]) * width);
            if (leftMove) {
                ++leftPoint;
            } else {
                --rightpoint;
            }
        }
        return capacity;
    }
}
// @lc code=end

