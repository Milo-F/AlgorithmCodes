/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length < 3 || null == height) return 0;
        int len = height.length;
        int result = 0, startIndex = 0;
        int[] full = Arrays.copyOfRange(height, 0, len);
        while (height[startIndex] == 0) ++startIndex;
        fullPool(height, full, startIndex);
        for (int i = 0; i < len; ++i) {
            result = result + full[i] - height[i];
        }
        return result;
    }

    public void fullPool(int[] height, int[] full, int startIndex) {
        if (startIndex >= 0) {
            boolean is_down = false;
            int nextStart = -1;
            int maxLower = -1;
            for (int l = startIndex, r = startIndex + 1; r < height.length; ++r) {
                if (height[r] == 0) continue;
                if (height[r] >= height[l]) {
                    nextStart = r;
                    is_down = false;
                    break;
                } else {
                    is_down = true;
                    if (height[r] >= maxLower) {
                        maxLower = height[r];
                        nextStart = r;
                    }
                }
            }
            for (int i = startIndex + 1; i < nextStart; ++i) {
                full[i] = is_down ? height[nextStart] : height[startIndex];
            }
            fullPool(height, full, nextStart);
        }
    }
}
// @lc code=end

