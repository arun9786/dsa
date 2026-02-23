

5007.Rat in a Maze
Difficulty: MediumAccuracy: 35.75%Submissions: 402K+Points: 4Average Time: 25m
Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rats goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Input: maze[][] = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: DDRR and RRDD.
Constraints:
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1

Solution:-
class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        boolean visited[][]=new boolean[n][n];
        ArrayList<String> ans=new ArrayList<>();
        visited[0][0]=true;
        
        recursion(0,0,maze,visited,n,ans,"");
        return ans;
    }
    
    void recursion(int row,int col,int[][] maze,boolean[][] visited,int n,List<String> ans,String temp){
        if(row>=n || col>=n) return;
        if(row==n-1 && col==n-1){
            ans.add(temp);
            return;
        }
        if(row+1<n && maze[row+1][col]==1 && !visited[row+1][col]){
           visited[row+1][col]=true;
           recursion(row+1,col,maze,visited,n,ans,temp+"D");
           visited[row+1][col]=false;
        }
        if(col-1>=0 && maze[row][col-1]==1 && !visited[row][col-1]){
           visited[row][col-1]=true;
           recursion(row,col-1,maze,visited,n,ans,temp+"L");
           visited[row][col-1]=false;
        }
        if(col+1<n && maze[row][col+1]==1 && !visited[row][col+1]){
           visited[row][col+1]=true;
           recursion(row,col+1,maze,visited,n,ans,temp+"R");
           visited[row][col+1]=false;
        }
        if(row-1>=0 && maze[row-1][col]==1 && !visited[row-1][col]){
           visited[row-1][col]=true;
           recursion(row-1,col,maze,visited,n,ans,temp+"U");
           visited[row-1][col]=false;
        }
    }
}

Time Complexity: O(4^(n*n)) in the worst case, where n is the size of the maze. This is because in the worst case, the rat can move in four directions at each step, and there can be at most n*n steps to reach the destination.
Space Complexity: O(n*n) for the visited array and O(n*n) for the recursionion stack in the worst case, resulting in O(n*n) overall. The space required to store the final answer is not considered in this analysis.

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        ArrayList<String> ans=new ArrayList<>();
        maze[0][0]=0;
        recursion(0,0,maze,n,ans,"");
        maze[0][0]=1;
        return ans;
    }
    
    void recursion(int row,int col,int[][] maze,int n,List<String> ans,String temp){
        if(row>=n || col>=n) return;
        if(row==n-1 && col==n-1){
            ans.add(temp);
            return;
        }
        if(row+1<n && maze[row+1][col]==1){
           maze[row+1][col]=0;
           recursion(row+1,col,maze,n,ans,temp+"D");
           maze[row+1][col]=1;
        }
        if(col-1>=0 && maze[row][col-1]==1){
           maze[row][col-1]=0;
           recursion(row,col-1,maze,n,ans,temp+"L");
           maze[row][col-1]=1;
        }
        if(col+1<n && maze[row][col+1]==1){
           maze[row][col+1]=0;
           recursion(row,col+1,maze,n,ans,temp+"R");
           maze[row][col+1]=1;
        }
        if(row-1>=0 && maze[row-1][col]==1){
           maze[row-1][col]=0;
           recursion(row-1,col,maze,n,ans,temp+"U");
           maze[row-1][col]=1;
        }
    }
}

Time Complexity: O(4^(n*n)) in the worst case, where n is the size of the maze. This is because in the worst case, the rat can move in four directions at each step, and there can be at most n*n steps to reach the destination.
Space Complexity: O(n*n) for the recursionion stack in the worst case, resulting in O(n*n) overall. The space required to store the final answer is not considered in this analysis. The space used for the maze is not considered in this analysis as it is modified in place and does not require additional space.