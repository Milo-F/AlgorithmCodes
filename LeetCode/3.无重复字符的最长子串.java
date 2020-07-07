import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        HashSet charHashSet = new HashSet<Character>();
        int rightPoint = 0, result = 0;
        char[] sChar = s.toCharArray();
        for (int leftPoint = 0; leftPoint < s.length(); ++leftPoint) {
            if (leftPoint != 0) {
                charHashSet.remove(sChar[leftPoint - 1]);
            }
            while (rightPoint < s.length() && !charHashSet.contains(sChar[rightPoint])) {
                charHashSet.add(sChar[rightPoint]);
                ++rightPoint;
            }
            result = Math.max(result, rightPoint - leftPoint);
            if (rightPoint == s.length()) {
                break;
            }
        }
        return result;
    }
}
// @lc code=end

