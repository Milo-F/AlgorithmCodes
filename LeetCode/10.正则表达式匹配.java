/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int sLen = s.length, pLen = p.length;
        boolean[][] pd = new boolean[sLen][pLen];
        pd[0][0] = true;
        for (int i = 0; i < pLen; ++i) {
            for (int j = 0; j < sLen; ++j) {
                
            }
        }
    }
}
// @lc code=end

