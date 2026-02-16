https://leetcode.com/problems/find-triangular-sum-of-an-array/description/

2221. Find Triangular Sum of an Array
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

The triangular sum of nums is the value of the only element present in nums after the following process terminates:

Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
Replace the array nums with newNums.
Repeat the entire process starting from step 1.
Return the triangular sum of nums.

 

Example 1:


Input: nums = [1,2,3,4,5]
Output: 8
Explanation:
The above diagram depicts the process from which we obtain the triangular sum of the array.
Example 2:

Input: nums = [5]
Output: 5
Explanation:
Since there is only one element in nums, the triangular sum is the value of that element itself.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 9

Solution:
class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        for(int row=0;row<n-1;row++){
            for(int cell=0;cell<n-row-1;cell++){
                nums[cell]=(nums[cell]+nums[cell+1])%10;
            }
        }
        return nums[0];
    }
}

Time Complexity: O(n^2) for generating the triangular sum, as we need to perform n-1 iterations for the rows and in each row, we perform n-row-1 iterations for the cells. The total number of operations is (n-1) + (n-2) + ... + 1 = n * (n - 1) / 2, which simplifies to O(n^2).
Space Complexity: O(1) for using the input array `nums` to store the intermediate results, as we are modifying the array in place and not using any additional data structures.

Explanation:
1. We first determine the length of the input array `nums` and store it in variable `n`.
2. We then iterate through the rows of the triangular sum process, starting from 0 to n-2 (inclusive). This is because we need to perform n-1 iterations to reduce the array to a single element.
3. For each row, we iterate through the cells of the current row, starting from 0 to n-row-2 (inclusive). This is because in each row, the number of elements reduces by one.
4. For each cell, we calculate the new value by adding the current cell value and the next cell value, and then taking the result modulo 10. We store this new value back in the current cell of the `nums` array.
5. After processing all rows, the first element of the `nums` array will contain the final triangular sum, which we return as the result.

Example:
Input: nums = [1,2,3,4,5]
Output: 8
- After first row: nums = [3, 5, 7, 9]
- After second row: nums = [8, 2, 6]
- After third row: nums = [0, 8]
- After fourth row: nums = [8]
- Final output: 8
Input: nums = [5]
Output: 5
- Since there is only one element, the triangular sum is 5.