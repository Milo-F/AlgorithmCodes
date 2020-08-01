/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1, index = 0;
        if (len == 0) return -1;
        if (nums[0] == target) return 0;
        if (nums[len - 1] == target) return len - 1;
        while (r > l) {
            index = (l + r) >> 1;
            if (index == l) {
                if (nums[r] == target) return r;
                r = index;
            }
            if (index > 0 && nums[index] < nums[index - 1] && target < nums[index]) return -1;
            if (index < len - 1 && nums[index] > nums[index + 1] && target > nums[index]) return -1;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] > nums[l]) {
                if (target < nums[index] && target > nums[l]) {
                    r = index;
                } else {
                    l = index;
                }
            } else {
                if (target > nums[index] && target < nums[r]) {
                    l = index;
                } else {
                    r = index;
                }
            }
        }
        return nums[index] == target ? index : -1;
    }
}
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

