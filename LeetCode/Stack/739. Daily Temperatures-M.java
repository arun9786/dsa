https://leetcode.com/problems/daily-temperatures/description/?envType=problem-list-v2&envId=monotonic-stack

739. Daily Temperatures
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

Solution:-
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int ans[]=new int[n];
        Stack<Integer> stk=new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans[i]=0;
            } else{
                ans[i]=stk.peek()-i;
            }
            stk.push(i);
        }
        return ans;

    }
}

Time Complexity: O(n) where n is the length of the input array temperatures. We traverse the array once, and each index is pushed and popped from the stack at most once, resulting in O(n) time complexity.
Space Complexity: O(n) in the worst case, if the temperatures are in decreasing order, the stack will hold all indices, resulting in O(n) space complexity. In the best case, if the temperatures are in increasing order, the stack will hold only one index at a time, resulting in O(1) space complexity. Therefore, the overall space complexity is O(n).