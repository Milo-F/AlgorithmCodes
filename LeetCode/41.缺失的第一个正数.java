/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len == 0 || nums == null) return 1;
        if (nums[len - 1] <= 0) return 1;
        // 用二分法找到0的位置
        int l = 0, r = len - 1, mid = 0;
        while (r >= l) {
            mid = (l + r) >> 1;
            if (nums[mid] == 0) {
                break;
            } else if (0 > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (nums[mid] < 0) ++mid;
        if (nums[mid] > 1) return 1;
        // 找到间距大于等于2的正数位置
        for (int i = mid + 1; i < len; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i - 1] + 1;
            }
        }
        return nums[len - 1] + 1;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len == 0 || nums == null) return 1;
        if (nums[len - 1] <= 0 || nums[0] > 1) return 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i] == 1) continue;
            if (nums[i] > 0 && nums[i] - nums[i - 1] > 1) {
                if (nums[i - 1] < 0) return 1;
                return nums[i - 1] + 1;
            }
        }
        return nums[len - 1] + 1;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0, len);
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0 && nums[i] <= len) {// nums[i]要作为temp的索引nums[i] - 1使用，所以可以等于len
                temp[nums[i] - 1] = nums[i];// temp数组的第N个位置放数字N
            }
        }
        for (int i = 0; i < len; ++i) {
            if (temp[i] != i + 1) {
                return i + 1;
                // 如果出现了第N个（从 1 开始计）位置上的数字不是N，则说明原数组缺失这个数字N，N就是缺失的最小正数
            }
        }
        return len + 1;
    }
}
// @lc code=end

