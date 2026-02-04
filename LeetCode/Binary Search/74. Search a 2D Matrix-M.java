https://leetcode.com/problems/search-a-2d-matrix/description/

74. Search a 2D Matrix
Solved
Medium
Topics
premium lock icon
Companies
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

Solution:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int midValue=matrix[mid/n][mid%n];
            if(midValue==target){
                return true;
            }
            else if(midValue<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}

Time Complexity: O(log(m*n)) for binary search.
Space Complexity: O(1) as no extra space is used.

Explanation:
1. Treat the 2D matrix as a 1D sorted array by calculating the midpoint.
2. Use binary search to find the target:
   - Calculate mid index and convert it to 2D indices using mid/n and mid%n.
   - Compare the midValue with the target and adjust the search range accordingly.
Example Walkthrough:
Consider the matrix:
[[1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]]
and target = 3.
- Initial: left = 0, right = 11 (3*4-1)
- Iteration 1: mid = 5, midValue = matrix[1][1] = 11 > 3, move right to 4
- Iteration 2: mid = 2, midValue = matrix[0][2] = 5 > 3, move right to 1
- Iteration 3: mid = 0, midValue = matrix[0][0] = 1 < 3, move left to 1
- Iteration 4: mid = 1, midValue = matrix[0][1] = 3 == 3, return true.