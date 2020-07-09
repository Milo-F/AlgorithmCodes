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
/* 
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
作者：guanpengchn
链接：https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
// @lc code=end

