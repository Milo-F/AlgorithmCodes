/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length, result = 0;
        if (len < 3) return result;
        Arrays.sort(nums);
        int sum = 0, distance = 0, minDis = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; ++i) {           
            int j = i + 1, k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                distance = Math.abs(sum - target);
                if (distance < minDis) {
                    minDis = distance;
                    result = sum;
                } else if (sum - target < 0) {
                    // while (j + 1 < len - 1 && nums[j + 1] == nums[j]) 
                    ++j;
                } else {
                    // while (k > j && nums[k - 1] == nums[k]) 
                    --k;
                }
            }
        }
        return result;
    }
}
// 错误解法！ 先找到最接近的两数的和，再加上除这两个数之外和最接近target的数。
// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         int len = nums.length;
//         if (len < 3) return 0;
//         int result = 0, sumOfTow = 0, distance = 0, minDis = Integer.MAX_VALUE;
//         int lLocation = 0, rLocation = 0;
//         Arrays.sort(nums);
//         for (int lPoint = 0, rPoint = len - 1; lPoint < rPoint; ) {
//             sumOfTow = nums[lPoint] + nums[rPoint];
//             distance = Math.abs(sumOfTow - target);
//             if (distance < minDis) {
//                 minDis = distance;
//                 result = sumOfTow;
//                 lLocation = lPoint;
//                 rLocation = rPoint;
//             } else if (sumOfTow - target > 0) {
//                 --rPoint;
//             } else {
//                 ++lPoint;
//             }
//         }
//         minDis = Integer.MAX_VALUE;
//         int thirdNum = 0;
//         for (int i = 0; i < len; ++i) {
//             if (i == lLocation || i == rLocation) continue;
//             distance = Math.abs(target - (result + nums[i]));
//             if (distance < minDis) {
//                 minDis = distance;
//                 thirdNum = nums[i];
//             }
//         }
//         return result + thirdNum;
//     }
// }
// @lc code=end

