https://leetcode.com/problems/maximum-subarray/description/

53. Maximum Subarray
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Solution:-
Brute Force Approach:
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int currentSum=0;
            for(int j=i;j<nums.length;j++){
                currentSum+=nums[j];
                maxSum=Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
}
Time Complexity: O(n^2) where n is the length of the input array nums.
Space Complexity: O(1) as we are using only a constant amount of extra space.

Optimal Approach (Kadanes Algorithm):
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int num:nums){
            currentSum+=num;
            maxSum=Math.max(maxSum,currentSum);
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }
}
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) as we are using only a constant amount of extra space.

Explanation:
1. We initialize two variables, maxSum to store the maximum sum found so far and currentSum to store the sum of the current subarray we are evaluating.
2. We iterate through each number in the input array nums.
3. For each number, we add it to currentSum and update maxSum if currentSum is greater than maxSum.
4. If currentSum becomes negative, we reset it to 0, as a negative sum would not contribute to a maximum sum in future iterations.
5. After iterating through the entire array, we return maxSum, which contains the largest sum of a contiguous subarray found.
Example:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
- We start with maxSum = Integer.MIN_VALUE and currentSum = 0.
- We iterate through the array:
  - For -2: currentSum = -2, maxSum = -2 (updated)
  - For 1: currentSum = -1, maxSum = -1 (updated)
  - For -3: currentSum = -4, maxSum = -1 (not updated), currentSum reset to 0
  - For 4: currentSum = 4, maxSum = 4 (updated)
  - For -1: currentSum = 3, maxSum = 4 (not updated)
  - For 2: currentSum = 5, maxSum = 5 (updated)
  - For 1: currentSum = 6, maxSum = 6 (updated)
  - For -5: currentSum = 1, maxSum = 6 (not updated)
  - For 4: currentSum = 5, maxSum = 6 (not updated)
- We finish iterating and return maxSum = 6, which is the largest sum of a contiguous subarray found.
Input: nums = [1]
- We start with maxSum = Integer.MIN_VALUE and currentSum = 0.
- We iterate through the array:
  - For 1: currentSum = 1, maxSum = 1 (updated)
- We finish iterating and return maxSum = 1, which is the largest sum of a contiguous subarray found.
Input: nums = [5,4,-1,7,8]
- We start with maxSum = Integer.MIN_VALUE and currentSum = 0.
- We iterate through the array:
  - For 5: currentSum = 5, maxSum = 5 (updated)
  - For 4: currentSum = 9, maxSum = 9 (updated)
  - For -1: currentSum = 8, maxSum = 9 (not updated)
  - For 7: currentSum = 15, maxSum = 15 (updated)
  - For 8: currentSum = 23, maxSum = 23 (updated)
- We finish iterating and return maxSum = 23, which is the largest sum of a contiguous subarray found.