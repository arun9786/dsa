https://leetcode.com/problems/arithmetic-slices/description/

413. Arithmetic Slices
Solved
Medium
Topics
premium lock icon
Companies
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

Solution:
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int left=0,count=0;
        for(int right=2;right<nums.length;right++){
            if(nums[left]-nums[left+1]==nums[right-1]-nums[right]){
                count+=(right-left-2+1);
            } else{
                left=right-1;
            }
        }
        return count;
    }
}
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.