/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] sChar = s.toCharArray();
        ArrayList<StringBuilder> ans = new ArrayList<StringBuilder>(numRows);
        for (int i = 0; i < numRows; ++i) {
            ans.add(new StringBuilder());
        }
        StringBuilder result = new StringBuilder();
        int direction = 1, len = s.length(), row = 0;
        for (int i = 0; i < len; ++i) {
            ans.get(row).append(sChar[i]);
            row = row + direction;
            if (row == 0 || row == numRows - 1) {
                direction = -direction;
            }
        }
        for (int i = 0; i < numRows; ++i) {
            result.append(ans.get(i).toString());
        }
        return result.toString();
    }
}
// @lc code=end

