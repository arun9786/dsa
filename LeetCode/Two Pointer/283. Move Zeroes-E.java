https://leetcode.com/problems/move-zeroes/submissions/1885389368/

283. Move Zeroes
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums, move all 0s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?

Solution:-

class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
    }
}

Time Complexity: O(n) for traversing the array once.
Space Complexity: O(1) as we are using only constant space.