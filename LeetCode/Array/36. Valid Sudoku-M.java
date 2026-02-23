https://leetcode.com/problems/valid-sudoku/description/

36. Valid Sudoku
Solved
Medium
Topics
premium lock icon
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8s in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

Solution:-

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isCorrect(i,j,board[i][j],board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isCorrect(int row, int col, char val,char[][] board){
        for(int c=0;c<9;c++){
            if(c!=col && board[row][c]==val){
                return false;
            }
        }

        for(int r=0;r<9;r++){
            if(r!=row && board[r][col]==val){
                return false;
            }
        }

        int startRow=row/3*3;
        int startCol=col/3*3;
        for(int r=startRow;r<startRow+3;r++){
            for(int c=startCol;c<startCol+3;c++){
                if(!(r==row && c==col) && board[r][c]==val) return false;
            }
        }

        return true;
    }
}
Time Complexity: O(1) since the board size is fixed (9x9).
Space Complexity: O(1) since we are using a constant amount of space for the validation checks.