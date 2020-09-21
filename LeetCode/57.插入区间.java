/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // if (intervals == null || intervals.length == 0) return {newInterval};
        int num = intervals.length;
        int l = 0, r = num - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (newInterval[0] == intervals[mid][0]) {
                break;
            } else if (newInterval[0] > intervals[mid][0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        mid = newInterval[0] >= intervals[mid][0] ? mid : mid - 1;
        List<int[]> temp = new ArrayList<>();
        for (int i = 0, mergeEnd = 0; i < num; ++i) {
            if (i < mid || i > mergeEnd) {
                temp.add(intervals[i]);
            } else {
                if (intervals[mid][1] < newInterval[0]) {
                    temp.add(intervals[i]);
                    continue;
                } else {
                    newInterval[0] = intervals[i][0];
                    for (int j = i + 1;  j < num && intervals[j][0] > newInterval[1]; ++j) {
                        mergeEnd = j;
                    }
                    newInterval[1] = intervals[mergeEnd][1];
                }
                temp.add(newInterval);
                i = mergeEnd;
            }
        }
        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); ++i) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
// @lc code=end
