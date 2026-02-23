https://leetcode.com/problems/n-queens-ii/

52. N-Queens II
Solved
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9

class Solution {
    public int totalNQueens(int n) {
        boolean marked[][]=new boolean[n][n];
        return recursion(0,marked,marked.length);
    }

    int recursion(int row,boolean[][] marked,int n){
        int count=0;
        if(row==n){
            return 1;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,marked)){
                marked[row][col]=true;
                count+=recursion(row+1,marked,n);
                marked[row][col]=false;
            }
        }
        return count;
    }

    boolean isSafe(int row,int col, boolean[][] marked){
        for(int r=0;r<row;r++){
            if(marked[r][col]) return false;
        }

        int r=row-1,c=col-1;
        while(r>=0 && c>=0){
            if(marked[r][c]) return false;
            r--;
            c--;
        }

        r=row-1;c=col+1;
        while(r>=0 && c<marked.length){
            if(marked[r][c]) return false;
            r--;
            c++;
        }
        return true;
    }

}

Time Complexity: O(N!) where N is the number of queens. This is because in the worst case, we have to explore all possible arrangements of queens on the board.
Space Complexity: O(N^2) for the marked array used to keep track of the positions of the queens, and O(N) for the recursion stack, resulting in O(N^2) overall. The space required to store the final answer is not considered in this analysis.