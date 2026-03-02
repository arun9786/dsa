https://leetcode.com/problems/largest-rectangle-in-histogram/description/

84. Largest Rectangle in Histogram
Solved
Hard
Topics
premium lock icon
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

Solution:-
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk=new Stack<>();
        int n=heights.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                int index=stk.pop();
                nse[index]=i;
            }
            if(stk.isEmpty()){
                pse[i]=-1;
            } else{
                pse[i]=stk.peek();
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nse[stk.pop()]=n;
        }
        for(int i=0;i<n;i++){
            max=Math.max(max, (nse[i]-pse[i]-1)*heights[i]);
        }
        return max;
    }
}

Time Complexity: O(n), where n is the number of bars in the histogram. Each bar is pushed and popped from the stack at most once.
Space Complexity: O(n), where n is the number of bars in the histogram. The stack can hold at most n indices, and we also use two additional arrays of size n to store the previous smaller and next smaller elements.