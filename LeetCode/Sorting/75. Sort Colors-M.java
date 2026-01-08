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