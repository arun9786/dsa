https://leetcode.com/problems/3sum-closest/description/

16. 3Sum Closest
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

Solution:
import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int closestSum=nums[0]+nums[1]+nums[2];;
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int currentSum=nums[i]+nums[left]+nums[right];
                if(Math.abs(currentSum-target)<Math.abs(closestSum-target)){
                    closestSum=currentSum;
                }
                if(currentSum==target){
                    return currentSum;
                } else if(currentSum<target){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return closestSum;
    }
}

Time Complexity: O(n^2) where n is the length of the input array nums.
Space Complexity: O(log n) for sorting the array.