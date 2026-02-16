https://leetcode.com/problems/merge-intervals/description/

56. Merge Intervals
Solved
Medium
Topics
premium lock icon
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

Solution:
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> temp=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end && intervals[i][1]>=end){
                end=intervals[i][1];
            } else if(intervals[i][1]>end){
                temp.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        temp.add(new int[]{start,end});
        return temp.toArray(new int[temp.size()][]);
    }
}

Time Complexity: O(n log n) for sorting the intervals, where n is the number of intervals. The merging process takes O(n) time, so the overall time complexity is O(n log n).
Space Complexity: O(n) for storing the merged intervals in the temporary list `temp`. The space used for sorting is O(log n) due to the sorting algorithm's stack space, but this is not considered additional space since we are modifying the input array in place.   

Explanation:
1. We first sort the intervals based on their starting times using `Arrays.sort()`. This ensures that we can easily merge overlapping intervals in a single pass.
2. We initialize two variables, `start` and `end`, to keep track of the current interval we are merging. We start with the first interval's start and end values.
3. We create a temporary list `temp` to store the merged intervals.
4. We iterate through the sorted intervals starting from the second interval:
   - If the current interval's start time is less than or equal to the `end` of the current merging interval, and its end time is greater than or equal to the `end`,   we update the `end` to the current interval's end time, effectively merging the intervals.
   - If the current interval's end time is greater than the `end`, it means there is no overlap, and we can add the current merging interval [start, end] to the `temp` list. We then update `start` and `end` to the current interval's start and end times.
5. After the loop, we add the last merging interval [start, end] to the `temp` list.
6. Finally, we convert the `temp` list to an array and return it as the result.

Example:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
- After sorting: intervals = [[1,3],[2,6],[8,10],[15,18]]
- Merging process:
  - Start with [1,3]: start = 1, end = 3
  - Next interval [2,6]: overlaps with [1,3], update end to 6
  - Next interval [8,10]: does not overlap, add [1,6] to temp, update start = 8, end = 10
  - Next interval [15,18]: does not overlap, add [8,10] to temp, update start = 15, end = 18
- Add last interval [15,18] to temp
- Final result: [[1,6],[8,10],[15,18]]
