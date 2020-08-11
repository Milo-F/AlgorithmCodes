/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length < 2 || matrix == null)
            return;
        int len = matrix.length;
        int l = 0, r = len - 1, width = 0;
        while (r > l) {
            width = r - l;
            int[] temp = new int[width];
            for (int i = l; i < r; ++i) {
                temp[i - l] = matrix[i][r];
                matrix[i][r] = matrix[l][i];
            }
            for (int i = l, num = 0; i < r; ++i) {
                num = matrix[r][i + 1];
                matrix[r][i + 1] = temp[width - i + l - 1];
                temp[width - i + l - 1] = num;
            }
            for (int i = l, num = 0; i < r; ++i) {
                num = matrix[i + 1][l];
                matrix[i + 1][l] = temp[width - i + l - 1];
                temp[width - i + l - 1] = num;
            }
            for (int i = l; i < r; ++i) {
                matrix[l][i] = temp[i - l];
            }
            ++l;
            --r;
        }
    }
}
// @lc code=end

