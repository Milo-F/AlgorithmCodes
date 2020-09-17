/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals == null || intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });// 自定义排序方式，重点
        int i = 0;
        for (int j = 1; j < intervals.length; ++j) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                ans.add(intervals[i]);
                i = j;
            }
        }
        ans.add(intervals[i]);
        int[][] result = new int[ans.size()][];
        for(int k = 0; k < ans.size(); ++k) {
            result[k] = ans.get(k);
        }
        return result;
    }
}
// @lc code=end

