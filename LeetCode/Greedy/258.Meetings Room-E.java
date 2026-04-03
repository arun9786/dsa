252. Meeting Rooms
📝 Problem Statement

Given an array of meeting time intervals intervals where
intervals[i] = [start_i, end_i], determine if a person could attend all meetings.

📥 Input

An array of intervals:

intervals[i] = [start_i, end_i]
📤 Output
Return true if a person can attend all meetings.
Return false if there is any overlap between meetings.
📌 Examples
Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Explanation:
Meeting [0,30] overlaps with [5,10], so it is not possible to attend all meetings.

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true

Explanation:
No meetings overlap, so all meetings can be attended.

Example 3:
Input: intervals = [[1,5],[5,10]]
Output: true

Explanation:
Meetings that end and start at the same time do not overlap.

⚠️ Constraints
1 <= intervals.length <= 10^4
0 <= start_i < end_i <= 10^6

Solution:
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int prevEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prevEnd){
                return false;
            }
            prevEnd=intervals[i][1];
        }
        return true;
    }
}

Time Complexity: O(n log n) for sorting the intervals, where n is the number of intervals. The iteration through the sorted intervals takes O(n) time, so the overall time complexity is O(n log n).
Space Complexity: O(1) if we ignore the space used for sorting, which is O(log n) due to the sorting algorithm's stack space. The space used for sorting is not considered additional space since we are modifying the input array in place. The space used for the output is O(1) since we are only returning a boolean value.