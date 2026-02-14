https://leetcode.com/problems/sort-colors/description/

75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the librarys sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Solution:-
class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for(int i:nums){
            if(i==0) zero++;
            else if(i==1) one++;
            else two++;
        }
        int index=0;
        while(zero-->0) nums[index++]=0;
        while(one-->0) nums[index++]=1;
        while(two-->0) nums[index++]=2;
    }
}

Time Complexity: O(n) for single pass through the array.
Space Complexity: O(1) for using constant extra space.

class Solution {
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<=right && nums[left]==0){
            left++;
        }
        while(right>=left && nums[right]==2){
            right--;
        }
        int mid=left;
        while(mid<=right){
            if(nums[mid]==2){
                int temp=nums[right];
                nums[right]=nums[mid];
                nums[mid]=temp;
                right--;
            } else if(nums[mid]==0){
                int temp=nums[left];
                nums[left]=nums[mid];
                nums[mid]=temp;
                left++;
                mid++;
            } else{
                mid++;
            }
        }
    }
}

Time Complexity: O(n) for single pass through the array.
Space Complexity: O(1) for using constant extra space.

Explanation:
1. We maintain three pointers: left, mid, and right.
2. The left pointer tracks the position to place the next 0, the right pointer tracks the position to place the next 2, and the mid pointer is used to traverse the array. 
3. We first move the left pointer to skip all leading 0s and the right pointer to skip all trailing 2s.
4. We then iterate through the array with the mid pointer:
   - If we encounter a 0, we swap it with the element at the left pointer and move both left and mid pointers forward.
   - If we encounter a 2, we swap it with the element at the right pointer and move the right pointer backward.
   - If we encounter a 1, we simply move the mid pointer forward.
5. This ensures that all 0s are moved to the front, all 2s to the back, and all 1s remain in the middle.
Explanation with example:
Consider the input nums = [2,0,2,1,1,0]
- Initially, left=0, mid=0, right=5
- After moving left and right pointers, left=0, right=5 (no leading 0s or trailing 2s)
- mid=0: nums[mid]=2, swap with nums[right], right=4 -> nums=[0,0,2,1,1,2]
- mid=0: nums[mid]=0, swap with nums[left], left=1, mid=1 -> nums=[0,0,2,1,1,2]
- mid=1: nums[mid]=0, swap with nums[left], left=2, mid=2 -> nums=[0,0,2,1,1,2]
- mid=2: nums[mid]=2, swap with nums[right], right=3 -> nums=[0,0,1,1,2,2]
- mid=2: nums[mid]=1, mid=3
- mid=3: nums[mid]=1, mid=4
- Now mid > right, we stop.
- The sorted array is [0,0,1,1,2,2].