https://leetcode.com/problems/max-consecutive-ones/description/

485. Max Consecutive Ones
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1s in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Solution:
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0,max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1){
                max=Math.max(right-left+1,max);
            } else{
                left=right+1;
            }
        }
        return max;
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            } else{
                count=0;
            }
            max=Math.max(count,max);
        }
        
        return max;
    }
}

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.