https://leetcode.com/problems/sudoku-solver/description/

37. Sudoku Solver
Solved
Hard
Topics
premium lock icon
Companies
Hint
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

Solution:-
class Solution {
    public void solveSudoku(char[][] board) {
        recursion(board);
    }

    boolean recursion(char[][] board){
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.'){
                    for(char i='1';i<='9';i++){
                        if(isCorrect(r,c,i,board)){
                            board[r][c]=i;
                            if(recursion(board)){
                                return true;
                            } else{
                                board[r][c]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCorrect(int row,int col,char val,char[][] board){
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
                if(!(r==row && c==col) && board[r][c]==val){
                    return false;
                }
            }
        }
        return true;
    }
}

Time Complexity: O(9^(N*N)) where N is the size of the board (in this case, N=9). This is because in the worst case, we may have to fill all N*N cells, and for each cell, we have 9 possible digits to try.
Space Complexity: O(N*N) for the recursion stack in the worst case, where N is the size of the board (in this case, N=9). This is because in the worst case, we may have to fill all N*N cells, and the recursion stack can go as deep as N*N. The space required to store the final answer is not considered in this analysis.