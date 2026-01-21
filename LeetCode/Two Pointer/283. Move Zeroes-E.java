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

Explanation:
1. We initialize a pointer left to keep track of the position to place the next non-zero element.
2. We iterate through the array with another pointer right.
3. Whenever we encounter a non-zero element at nums[right], we swap it with the element at nums[left] and increment left.
4. This way, all non-zero elements are moved to the front, and all zeros are moved to the end of the array.
Explanation with Example:
Consider the input array nums = [0,1,0,3,12]
- Initially, left = 0.
- We start iterating with right:
  - right = 0: nums[0] is 0, do nothing.
  - right = 1: nums[1] is 1, swap nums[1] with nums[0], array becomes [1,0,0,3,12], left = 1.
  - right = 2: nums[2] is 0, do nothing.
  - right = 3: nums[3] is 3, swap nums[3] with nums[1], array becomes [1,3,0,0,12], left = 2.
  - right = 4: nums[4] is 12, swap nums[4] with nums[2], array becomes [1,3,12,0,0], left = 3.
- The final array is [1,3,12,0,0] with all zeros moved to the end.