https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
premium lock icon
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

Solution:
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int LP=-1,RP=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    LP=mid;
                }
                right=mid-1;
            } else if(target>nums[mid]){
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        left=0;right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    RP=mid;
                }
                left=mid+1;
            } else if(target>nums[mid]){
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        return new int[]{LP,RP};
    }
}

Time Complexity: O(log n) for binary search.
Space Complexity: O(1) as no extra space is used.

Explanation:
1. We perform two binary searches: one to find the leftmost position (LP) and another to find the rightmost position (RP) of the target.
2. In the first binary search, when we find the target, we check if it's the first occurrence by checking if it's at index 0 or if the previous element is different. If so, we set LP to mid.
3. In the second binary search, when we find the target, we check if it's the last occurrence by checking if it's at the last index or if the next element is different. If so, we set RP to mid.
4. Finally, we return the array [LP, RP].

Example Walkthrough:
1. For nums = [5,7,7,8,8,10] and target = 8:
    - First Binary Search for LP:
        - Initial: left = 0, right = 5
        - Iteration 1: mid = 2, nums[2] = 7 < 8, move left to 3
        - Iteration 2: mid = 4, nums[4] = 8 == 8, check if its first occurrence (nums[3] = 8), move right to 3
        - Iteration 3: mid = 3, nums[3] = 8 == 8, check if its first occurrence (mid == 0 or nums[2] != 8), set LP = 3, move right to 2
        - End: LP = 3
    - Second Binary Search for RP:
        - Initial: left = 0, right = 5
        - Iteration 1: mid = 2, nums[2] = 7 < 8, move left to 3
        - Iteration 2: mid = 4, nums[4] = 8 == 8, check if its last occurrence (nums[5] = 10), set RP = 4, move left to 5
        - End: RP = 4
    - Result: [3, 4]
2. For nums = [5,7,7,8,8,10] and target = 6:
    - Both binary searches will not find the target, resulting in LP = -1 and RP = -1.
    - Result: [-1, -1]