/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int beginPoint1 = 0, beginPoint2 = 0;
        int k = 0;
        int m, n, halfTemp = 0, numKNext = 0;
        double result = 0.0;
        m = nums1.length;
        n = nums2.length;
        k = (int) (m + n) / 2;
        for ( ; k > 1 ; k = k / 2) {
            if (k >= m - beginPoint1) {
                result = nums2[beginPoint2 + k];
                numKNext = nums2[beginPoint2 + k + 1];
                break;
            }
            if (k >= n - beginPoint2) {
                result = nums1[beginPoint1 + k];
                numKNext = nums1[beginPoint1 + k + 1];
                break;
            }
            halfTemp = k / 2;
            if (nums1[beginPoint1 + halfTemp] > nums2[beginPoint2 + halfTemp]) {
                beginPoint2 = beginPoint2 + halfTemp + 1;
                result = nums2[beginPoint2 + k];
                numKNext = nums2[beginPoint2 + k + 1];
            } else {
                beginPoint1 = beginPoint1 + halfTemp + 1;
                result = nums1[beginPoint1 + k];
                numKNext = nums1[beginPoint1 + k + 1];
            }
        }
        if ((m + n) % 2 == 0) {
            result = (result + numKNext) / 2;
        }
        return result;
    }
}
// @lc code=end

