/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2 || null == nums) return 0;//如果数组的长度为1或者0，那么起始即终点
        int len = nums.length;
        int location = 0, result = 0;// location表示每次跳跃的起点
        while (location + nums[location] < len - 1) {// 如果下次跳跃可以到搭终点则结束。
            int temp = 0, maxDistance = 0;// temp用于保存跳最远的点
            for (int i = location + 1; i <= location + nums[location]; ++i) {
                //遍历该次跳跃距离内的所有点，找出能使下次跳得最远的点，最远可达，那其他点均可达
                if (i + nums[i] > maxDistance) {
                    maxDistance = i + nums[i];
                    temp = i;// 获取下次跳最远的点的位置
                }
            }
            location = temp;// 最优点作为下次跳跃的起点
            ++result;// 表示跳了一次
        }
        return result + 1;
    }
}
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp保存跳跃至该点的最短跳跃次数
        for(int i = 1 , j = 0 ; i < n ; i++){
            while(j + nums[j] < i) j++;// i超出跳跃范围，j++
            dp[i]  = dp[j] + 1;// i还在跳跃范围，i点步数为跳到j点步数加一步
        }
        return dp[n-1];// 返回跳至终点的最短步数
    }
}
// @lc code=end

