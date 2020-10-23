/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        for (int i = len - 1; i > 0 && digits[i] == 10; --i) {
                digits[i] = 0;
                digits[i - 1]++;
        }
        if (digits[0] == 10) {
            int[] ans = new int[len + 1];
            ans[0] = 1;
            digits[0] = 0;
            for (int i : digits) {
                ans[i + 1] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}
// @lc code=end

