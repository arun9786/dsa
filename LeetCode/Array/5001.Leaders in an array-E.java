https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

5001.Array Leaders
Difficulty: EasyAccuracy: 29.94%Submissions: 980K+Points: 2Average Time: 15m
You are given an array arr of positive integers. Your task is to find all the leaders in the array. 
An element is considered a leader if it is greater than or equal to all elements to its right. 
The rightmost element is always a leader.

Examples:

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: arr = [5, 10, 20, 40]
Output: [40]
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: arr = [30, 10, 10, 5]
Output: [30, 10, 10, 5]
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 106


Solution:
import java.util.ArrayList;
class Solution {    public ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> leaders=new ArrayList<>();
        int maxFromRight=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=maxFromRight){
                leaders.add(arr[i]);
                maxFromRight=arr[i];
            }
        }
        return leaders;
    }
}
Time Complexity: O(n) where n is the length of the input array arr.
Space Complexity: O(k) where k is the number of leaders in the input array arr.

Explanation:
1. We initialize an empty list to store the leaders and a variable maxFromRight to keep track of the maximum element we have seen from the right side of the array.
2. We iterate through the array from right to left. For each element:
   - If the current element is greater than or equal to maxFromRight, it means it is a leader. We add it to the leaders list and update maxFromRight to the current element.
3. After iterating through the array, we return the list of leaders. Note that the leaders are added in reverse order, so if we want them in the original order, we can reverse the list before returning it.


Example:Input: arr = [16, 17, 4, 3, 5, 2]
- We start with an empty list of leaders and maxFromRight set to Integer.MIN_VALUE.
- We iterate through the array from right to left:
  - For 2: 2 >= Integer.MIN_VALUE, add 2 to leaders, update maxFromRight to 2.
  - For 5: 5 >= 2, add 5 to leaders, update maxFromRight to 5.
  - For 3: 3 >= 5 is false, do nothing.
  - For 4: 4 >= 5 is false, do nothing. 
  - For 17: 17 >= 5, add 17 to leaders, update maxFromRight to 17.
  - For 16: 16 >= 17 is false, do nothing.
- The leaders list now contains [2, 5, 17]. We can reverse it to get [17, 5, 2] before returning.