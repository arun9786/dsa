https://leetcode.com/problems/first-missing-positive/description/

41. First Missing Positive
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

Solution:-

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean arr[]=new boolean[n+1];
        for(int val:nums){
            if(val>0 && val<=n+1){
                arr[val-1]=true;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!arr[i]) return i+1;
        }
        return -1;
    }
}

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are not using any extra space.