/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 4 || (len == 4 && nums[0] + nums[1] + nums[2] + nums[3] != target)) return result;
        for (int i = 0; i < len - 3; ++i) {
            while(i < len - 3 && i > 0 && nums[i - 1] == nums[i]) ++i;
            for (int j = i + 1; j < len - 2; ++j) {
                while(j < len-2 && j > i + 1 && nums[j-1] == nums[j]) ++j;
                int lPoint = j + 1;
                int rPoint = len - 1;
                int sum = 0;
                while(rPoint > lPoint) {
                    sum = nums[i] + nums[j] + nums[lPoint] + nums[rPoint];
                    if (sum == target) {
                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[lPoint]);
                        temp.add(nums[rPoint]);
                        result.add(temp);
                        ++lPoint;
                        while(lPoint < rPoint && lPoint > j + 1 && nums[lPoint - 1] == nums[lPoint]) ++lPoint;
                        --rPoint;
                        while(lPoint < rPoint && rPoint < len - 1 && nums[rPoint + 1] == nums[rPoint]) --rPoint;
                    } else if (sum > target) {
                        --rPoint;
                        while(lPoint < rPoint && rPoint < len - 1 && nums[rPoint + 1] == nums[rPoint]) --rPoint;
                    } else {
                        ++lPoint;
                        while(lPoint < rPoint && lPoint > j + 1 && nums[lPoint - 1] == nums[lPoint]) ++lPoint;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

