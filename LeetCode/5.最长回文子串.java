/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
// //暴力解法
// class Solution {
//     public String longestPalindrome(String s) {
//         if (s.length() < 2) {
//             return s;
//         }
//         int len = s.length();
//         int begin = 0, maxLen = 1;
//         char[] sChar = s.toCharArray();
//         for (int i = 0; i < len - 1; ++i) {
//             for (int j = i + 1; j < len ; ++j) {
//                 if (j - i + 1 > maxLen && booleanString(sChar, i, j)) {
//                     maxLen = j - i + 1;
//                     begin = i;
//                 }
//             }
//         }
//         return s.substring(begin, begin + maxLen);
//     }
//     public boolean booleanString(char[] s, int left, int right) {
//         while (right > left) {
//             if (s[right] != s[left]) {
//                 return false;
//             }
//             ++left;
//             --right;
//         }
//         return true;
//     }
// }
// 动态规划
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int index = 0, maxLen = 1;
        char[] sChar = s.toCharArray();
        for (int j = 0; j < len; ++j) {
            for(int i = 0; i < j; ++i) {
                if (sChar[i] != sChar[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i +1 > maxLen) {
                    maxLen = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + maxLen);
    } 
}
// @lc code=end

