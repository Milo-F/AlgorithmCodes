/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        char[] strChar = str.toCharArray();
        int len = str.length();
        boolean negative = false, nextIsNumber = false;
        long ans = 0;
        for (int i = 0; i < len; ++i) {
            switch (strChar[i]) {
            case ' ' :
                i = nextIsNumber ? len : i;
                break;
            case '-' :
                if (nextIsNumber) {
                    i = len;
                    break;
                }
                nextIsNumber = true;
                negative = true;
                break;
            case '+' :
                if (nextIsNumber) {
                    i = len;
                    break;
                }
                nextIsNumber = true;
                negative = false;
                break;
            default :
                if ((strChar[i] < '0' || strChar[i] > '9')) {
                    i = len;
                } else {
                    nextIsNumber = true;
                    if (ans * 10 + strChar[i] - 48 > Integer.MAX_VALUE) {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    } else {
                        ans = ans * 10 + strChar[i] - 48;
                    }
                }
            }
        }
        ans = negative ? -ans : ans;
        return (int)ans;
    }
}
// @lc code=end

