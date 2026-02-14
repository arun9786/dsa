https://leetcode.com/problems/spiral-matrix/description/

54. Spiral Matrix
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

Solution:-
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int top=0,right=c-1,bottom=r-1,left=0;
        List<Integer> ans=new ArrayList<>();
        while(left<=right && top<=bottom){
            //left to right
            for(int col=left;col<=right;col++){
                ans.add(matrix[top][col]);
            }
            top++;
            //top to bottom
            for(int row=top;row<=bottom;row++){
                ans.add(matrix[row][right]);
            }
            right--;
            //right to left
            if(top<=bottom){
                for(int col=right;col>=left;col--){
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }
            //bottom to top
            if(left<=right){
                for(int row=bottom;row>=top;row--){
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }
        return ans;
    }
}

Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the input matrix.
Space Complexity: O(m*n) for storing the elements in the answer list.

Explanation:
1. We initialize four pointers: top, right, bottom, and left to keep track of the boundaries of the matrix that we need to traverse.
2. We use a while loop that continues until the left pointer is less than or equal to the right pointer and the top pointer is less than or equal to the bottom pointer.
3. Inside the loop, we traverse from left to right along the top row, then we move the top pointer down. Next, we traverse from top to bottom along the right column, then we move the right pointer left. After that, if there are still rows to traverse, we traverse from right to left along the bottom row, then we move the bottom pointer up. Finally, if there are still columns to traverse, we traverse from bottom to top along the left column, then we move the left pointer right.
4. We add each element we traverse to the answer list. After the loop finishes, we return the answer list containing all the elements in spiral order.

Example:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
- We start with top=0, right=2, bottom=2, left=0, and an empty answer list.
- We traverse from left to right along the top row: add 1, 2, 3 to the answer list. Now top=1.
- We traverse from top to bottom along the right column: add 6, 9 to the answer list. Now right=1.
- We traverse from right to left along the bottom row: add 8, 7 to the answer list. Now bottom=1.
- We traverse from bottom to top along the left column: add 4 to the answer list. Now left=1.
- We traverse from left to right along the top row: add 5 to the answer list. Now top=2.
- We traverse from top to bottom along the right column: no elements to add. Now right=0.
- We traverse from right to left along the bottom row: no elements to add. Now bottom=0.
- We traverse from bottom to top along the left column: no elements to add. Now left=2.
- The loop ends and we return the answer list: [1, 2, 3, 6, 9, 8, 7, 4, 5].
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
- We start with top=0, right=3, bottom=2, left=0, and an empty answer list.
- We traverse from left to right along the top row: add 1, 2, 3, 4 to the answer list. Now top=1.
- We traverse from top to bottom along the right column: add 8, 12 to the answer list. Now right=2.
- We traverse from right to left along the bottom row: add 11, 10, 9 to the answer list. Now bottom=1.
- We traverse from bottom to top along the left column: add 5 to the answer list. Now left=1.
- We traverse from left to right along the top row: add 6, 7 to the answer list. Now top=2.
- We traverse from top to bottom along the right column: no elements to add. Now right=1.
- We traverse from right to left along the bottom row: no elements to add. Now bottom=0.
- We traverse from bottom to top along the left column: no elements to add. Now left=2.
- The loop ends and we return the answer list: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7].