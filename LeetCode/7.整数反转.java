/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        boolean b = false;
        if (x < 0) {
            x = Math.abs(x);
            b = true;
        }
        String s = String.valueOf(x);
        char temp = '0';
        char[] c = s.toCharArray();
        int len = c.length, ans = 0;
        if (len < 2) {
            return x;
        }
        for(int i = 0; i < len / 2; ++i) {
            temp = c[i];
            c[i] = c[len - i - 1];
            c[len - i - 1] = temp;
        }
        s = new String(c);
        if (len >= 10 && s.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
            return 0;
        }
        ans = Integer.valueOf(s).intValue();
        if (b) ans = -ans;
        return ans;
    }
}
// @lc code=end

