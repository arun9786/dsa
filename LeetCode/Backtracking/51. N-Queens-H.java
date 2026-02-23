https://leetcode.com/problems/n-queens/description/

51. N-Queens
Solved
Hard
Topics
premium lock icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

Solution:-
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        reursion(0,arr.length,arr,ans);
        return ans;
    }

    void reursion(int row,int n,char[][] arr,List<List<String>> ans){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(arr[i]));
            }
            ans.add(temp);
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row,col,arr)){
                arr[row][col]='Q';
                reursion(row+1,n,arr,ans);
                arr[row][col]='.';
            }
        }
    }

    boolean isSafe(int row,int col,char[][] arr){
        int n=arr.length;
        //same columns
        for(int r=0;r<row;r++){
            if(arr[r][col]=='Q') return false;
        }

        //diagnol top left
        int r=row-1,c=col-1;
        while(r>=0 && c>=0){
            if(arr[r][c]=='Q') return false;
            r--;
            c--;
        }
        //diagnol top right
        r=row-1;c=col+1;
        while(r>=0 && c<n){
            if(arr[r][c]=='Q') return false;
            r--;
            c++;
        }

        return true;
    }
}

Time Complexity: O(N!) where N is the number of queens. This is because in the worst case, we have to explore all possible placements of queens on the board.
Space Complexity: O(N^2) for the board representation and O(N) for the recursionn stack, resulting in O(N^2) overall. The space required to store the final answer is not considered in this analysis.