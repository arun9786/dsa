
5019.Merge k Sorted Arrays

Difficulty: MediumAccuracy: 67.25%Submissions: 128K+Points: 4Average Time: 45m
You are given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order. Your task is to merge all the rows and return a single sorted array that contains all the elements of the matrix.

Examples :

Input: mat[][] = [[1, 3, 5, 7],
                [2, 4, 6, 8], 
                [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4], 
                [2, 2, 3, 4],
                [5, 5, 6, 6],
                [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] 
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Constraints:
1 ≤ n * m ≤ 105
1 ≤ mat[i][j] ≤ 106

Solution:
class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        Queue<int[]> queue=new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );
        int totalNumbers=0;
        for(int i=0;i<mat.length;i++){
            queue.offer(new int[]{mat[i][0],i,0});
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(!queue.isEmpty()){
            int[] pair=queue.poll();
            int value=pair[0];
            int row=pair[1];
            int col=pair[2];
            result.add(value);
            if(mat[row].length>col+1){
                queue.offer(new int[]{mat[row][col+1],row,col+1});
            }
        }
        return result;
    }
}

Time Complexity: O(n*m*log(n)) where n is the number of rows and m is the number of columns in the matrix. This is because we are inserting n elements into the priority queue and each insertion takes O(log(n)) time.
Space Complexity: O(n) for the priority queue which can hold at most n elements at a time, where n is the number of rows in the matrix. The result list will take O(n*m) space to store all the elements of the matrix.