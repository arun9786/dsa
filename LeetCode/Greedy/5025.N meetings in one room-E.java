https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

5025.N meetings in one room
Difficulty: EasyAccuracy: 45.3%Submissions: 391K+Points: 2Average Time: 20m
You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Input: start[] = [1, 2], end[] = [100, 99]
Output: 1
Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 106

Solution:
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n=start.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=start[i];
            arr[i][1]=end[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int count=1;
        int prevEnd=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]>prevEnd){
                count++;
                prevEnd=arr[i][1];
            }
        }
        return count;
    }
}

Time Complexity: O(n log n) for sorting the meetings based on their end times, where n is the number of meetings. The iteration through the sorted meetings takes O(n) time, so the overall time complexity is O(n log n).
Space Complexity: O(n) for storing the meetings in a 2D array. The space used for sorting is O(log n) due to the sorting algorithm's stack space, but this is not considered additional space since we are modifying the input array in place. The space used for the output is O(1) since we are only returning an integer value representing the count of meetings.