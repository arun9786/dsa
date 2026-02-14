https://leetcode.com/problems/set-matrix-zeroes/description/

73. Set Matrix Zeroes
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0s.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Solution:
class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;

        boolean firstRowZero=false;
        boolean firstColZero=false;
        for(int i=0;i<c;i++){
            if(matrix[0][i]==0){
                firstRowZero=true;
                break;
            }
        }
        for(int i=0;i<r;i++){
            if(matrix[i][0]==0){
                firstColZero=true;
                break;
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int i=0;i<c;i++){
                matrix[0][i]=0;
            }
        }

        if(firstColZero){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
    }
}

Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the input matrix.
Space Complexity: O(1) as we are using only a constant amount of extra space to store the boolean variables and to mark the rows and columns that need to be set to zero.

Explanation:
1. We first check if the first row and first column of the matrix contain any zeros and store this information in the boolean variables firstRowZero and firstColZero.
2. We then iterate through the matrix starting from the second row and second column. If we find any element that is zero, we mark the corresponding first row and first column elements as zero to indicate that the entire row and column should be set to zero.
3. After marking the rows and columns, we iterate through the matrix again starting from the second row and second column. If we find any element in the first row or first column that is zero, we set the current element to zero.
4. Finally, if firstRowZero is true, we set the entire first row to zero, and if firstColZero is true, we set the entire first column to zero. This ensures that we have correctly set all the required rows and columns to zero based on the initial state of the first row and first column.
Example:
1.
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
- We check the first row and first column for zeros:
  - First row: no zeros, firstRowZero = false
  - First column: no zeros, firstColZero = false
- We iterate through the matrix starting from the second row and second column:
  - For matrix[1][1]: it is 0, we mark matrix[0][1] = 0 and matrix[1][0] = 0
- The matrix    now looks like [[1,0,1],[0,0,1],[1,1,1]]
- We iterate through the matrix again starting from the second row and second column:
  - For matrix[1][1]: it is 0, we set matrix[1][1] = 0
  - For matrix[1][2]: matrix[0][2] is not 0 and matrix[1][0] is 0, we set matrix[1][2] = 0
  - For matrix[2][1]: matrix[0][1] is 0, we set matrix[2][1] = 0    
  - For matrix[2][2]: matrix[0][2] is not 0 and matrix[2][0] is not 0, we do nothing 
- The matrix now looks like [[1,0,1],[0,0,0],[1,0,1]]
- Since firstRowZero is false, we do not modify the first row.
- Since firstColZero is false, we do not modify the first column.
- We return the modified matrix [[1,0,1],[0,0,0],[1,0,1]].
2.
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
- We check the first row and first column for zeros:
  - First row: contains zeros, firstRowZero = true
  - First column: contains zeros, firstColZero = true
- We iterate through the matrix starting from the second row and second column:
  - For matrix[1][3]: it is 2, we do nothing
  - For matrix[2][3]: it is 5, we do nothing
- The matrix remains [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
- We iterate through the matrix again starting from the second row and second column:
  - For matrix[1][1]: matrix[0][1] is not 0 and matrix[1][0] is 0, we set matrix[1][1] = 0
  - For matrix[1][2]: matrix[0][2] is not 0 and matrix[1][0] is 0, we set matrix[1][2] = 0
  - For matrix[1][3]: matrix[0][3] is 0, we set matrix[1][3] = 0
  - For matrix[2][1]: matrix[0][1] is not 0 and matrix[2][0] is 0, we set matrix[2][1] = 0
  - For matrix[2][2]: matrix[0][2] is not 0 and matrix[2][0] is 0, we set matrix[2][2] = 0
  - For matrix[2][3]: matrix[0][3] is 0, we set matrix[2][3] = 0
- The matrix now looks like [[0,1,2,0],[3,0,0,0],[1,0,0,0]]
- Since firstRowZero is true, we set the entire first row to zero: [[0,0,0,0],[3,0,0,0],[1,0,0,0]]
- Since firstColZero is true, we set the entire first column to zero: [[0,0,0,0],[0,0,0,0],[0,0,0,0]]
- We return the modified matrix [[0,0,0,0],[0,0,0,0],[0,0,0,0]].

