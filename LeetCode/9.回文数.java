/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        ArrayList<Integer> num = new ArrayList<>();
        while (x != 0) {
            num.add(x % 10);
            x = x / 10;
        }
        int len = num.size();
        for (int i = 0, j = len - 1; i < j; ++i, --j) {
            if (num.get(i) != num.get(j)) return false;
        }
        return true;
    }
}
// @lc code=end

