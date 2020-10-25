/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length, n = matrix[0].length;
//         int[][] originMatrix = new int[m][n];
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 if (matrix[i][j] != 0) {
//                     continue;
//                 } else {
//                     for (int k = 0; k < m; ++k) {
//                         originMatrix[k][j] = matrix[k][j];
//                     }
//                     for (int k = 0; k < n; ++k) {
//                         originMatrix[i][k] = matrix[i][k];
//                     }
//                 }
//             }
//         }
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) {
//                 matrix[i][j] = matrix[i][j] - originMatrix[i][j];
//             }
//         }
//     }
// }
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> location = new ArrayList<>(1);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] != 0) continue;
                else {
                    int[] tempLocation = {i, j};
                    location.add(tempLocation);
                }
            }
        }
        for (int[] temp : location) {
            for (int i = 0; i < m; ++i) {
                matrix[i][temp[1]] = 0;
            }
            for (int j = 0; j < n; ++j) {
                matrix[temp[0]][j] = 0;
            }
        }
    }
}
// @lc code=end

