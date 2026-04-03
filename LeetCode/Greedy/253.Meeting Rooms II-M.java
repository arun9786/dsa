

Difficulty: MediumAccuracy: 48.01%Submissions: 25K+Points: 4
Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Return the minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.

Examples:

Input: start[] = [1, 10, 7], end[] = [4, 15, 10]
Output: 1
Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.
Input: start[] = [2, 9, 6], end[] = [4, 12, 10]
Output: 2
Explanation: 1st and 2nd meetings at one room but for 3rd meeting one another room required.
Constraints:
1 ≤ start.size() = end.size() ≤ 105
0 ≤ start[i] < end[i] ≤ 106

Solution:
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        int n=start.length;
        int[][] intervals=new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0]=start[i];
            intervals[i][1]=end[i];
        }
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}

Time Complexity: O(n log n) for sorting the intervals, where n is the number of meetings. The iteration through the sorted intervals takes O(n) time, and each insertion and removal operation from the priority queue takes O(log m) time, where m is the number of rooms needed at that point. In the worst case, m can be equal to n, so the overall time complexity is O(n log n).
Space Complexity: O(n) for storing the intervals and the priority queue. The space used for sorting is O(log n) due to the sorting algorithm's stack space, but this is not considered additional space since we are modifying the input array in place. The space used for the priority queue can grow up to O(n) in the worst case when all meetings overlap, requiring n rooms.