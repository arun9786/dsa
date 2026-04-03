https://leetcode.com/problems/insert-interval/description/

57. Insert Interval
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105

Solution:
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        //Previous intervals
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        //merge intervals
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        //Remaining intervals
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

Time Complexity: O(n) where n is the number of intervals in the input array. We iterate through the intervals at most once to find the correct position for the new interval and to merge any overlapping intervals.
Space Complexity: O(n) for storing the merged intervals in the temporary list `ans`. The space used for the output array is also O(n) since we may need to return all intervals in the worst case.