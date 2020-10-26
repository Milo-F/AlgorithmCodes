/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix.length == 0 || matrix == null) return false;
//         int m = matrix.length, n = matrix[0].length;
//         boolean finish = false;
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 if (matrix[i][j] > target) {
//                     finish = true;
//                     break;
//                 }
//                 if (matrix[i][j] == target) return true;
//             }
//             if (finish) break;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    }
}
// @lc code=end

