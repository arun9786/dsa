https://leetcode.com/problems/maximal-rectangle/description/

85. Maximal Rectangle
Solved
Hard
Topics
premium lock icon
Companies
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.

Solution:-
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] heights=new int[n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                } else{
                    heights[j]=0;
                }
            }
            max=Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }
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
Time Complexity: O(m*n), where m and n are the number of rows and columns in the matrix respectively. We iterate through each cell of the matrix once, and for each row, we calculate the largest rectangle area in the histogram, which takes O(n) time.
Space Complexity: O(n), where n is the number of columns in the matrix. We use an array to store the heights of the histogram and a stack to calculate the largest rectangle area, both of which require O(n) space.