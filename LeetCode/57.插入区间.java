/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 || intervals == null) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        int l = 0, r = intervals.length - 1, mid = 0;
        while (l <= r) { // 二分查找法找到插入点mid
            mid = (l + r) >> 1;
            if (intervals[mid][0] == newInterval[0]) {
                break;
            } else if (newInterval[0] > intervals[mid][0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 确保在插入点后面插入新的区间
        mid = newInterval[0] >= intervals[mid][0] ? mid : mid - 1;
        mid = mid == -1 ? 0 : mid;
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            if (i < mid) {
                temp.add(intervals[i]);
            } else if (i == mid) {
                if (i == 0) {
                    if (newInterval[1] < intervals[0][0]) {
                        temp.add(newInterval);
                        temp.add(intervals[0]);
                    } else if (intervals[0][1] < newInterval[0]) {
                        temp.add(intervals[0]);
                        temp.add(newInterval);
                    } else {
                        temp.add(newInterval);
                        temp.get(0)[0] = Math.min(newInterval[0], intervals[i][0]);
                        temp.get(0)[1] = Math.max(newInterval[1], intervals[i][1]);
                        continue;
                    }
                } else {
                    temp.add(intervals[i]);
                    if (newInterval[0] <= intervals[i][1]) {
                        temp.get(temp.size() - 1)[1] = Math.max(newInterval[1], temp.get(temp.size() - 1)[1]);
                    } else {
                        temp.add(newInterval);
                    }
                }
            } else {
                if (intervals[i][0] <= temp.get(temp.size() - 1)[1]) {
                    temp.get(temp.size() - 1)[1] = Math.max(intervals[i][1], temp.get(temp.size() - 1)[1]);
                } else {
                    temp.add(intervals[i]);
                }
            }
        }
        int[][] ans = new int[temp.size()][];
        for (int i = 0; i < temp.size(); ++i) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
// @lc code=end
