https://leetcode.com/problems/binary-search/description/

704. Binary Search
Solved
Easy
Topics
premium lock icon
Companies
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

Solution:
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}

Time Complexity: O(log n) for binary search.
Space Complexity: O(1) as no extra space is used.

Explanation:
1. Initialize two pointers, left and right, to the start and end of the array.
2. While left is less than or equal to right:
   - Calculate mid as the average of left and right.
   - If nums[mid] equals target, return mid.
   - If nums[mid] is less than target, move the left pointer to mid + 1.
   - If nums[mid] is greater than target, move the right pointer to mid - 1.
3. If the target is not found, return -1.

Example Walkthrough:
1. For nums = [-1,0,3,5,9,12] and target = 9:
    - Initial: left = 0, right = 5
    - Iteration 1: mid = 2, nums[2] = 3 < 9, move left to 3
    - Iteration 2: mid = 4, nums[4] = 9 == 9, return 4.
2. For nums = [-1,0,3,5,9,12] and target = 2:
    - Initial: left = 0, right = 5
    - Iteration 1: mid = 2, nums[2] = 3 > 2, move right to 1
    - Iteration 2: mid = 0, nums[0] = -1 < 2, move left to 1
    - Iteration 3: mid = 1, nums[1] = 0 < 2, move left to 2
    - Now left > right, exit loop and return -1.