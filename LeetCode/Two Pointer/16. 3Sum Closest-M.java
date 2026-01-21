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

Explanation:
1. We first sort the input array nums.
2. We then iterate through the array, fixing one element at a time and using two pointers to find pairs that, along with the fixed element, produce a sum closest to the target.
3. We update the closest sum whenever we find a sum that is closer to the target than the previously recorded closest sum.
4. If we find a sum that exactly matches the target, we return it immediately.
5. Finally, we return the closest sum found.

Explanation with example:
Consider the input nums = [-1,2,1,-4], target = 1
- After sorting, nums becomes [-4,-1,1,2]
- We start with i=0 (nums[i]=-4), left=1, right=3
  - currentSum = -4 + (-1) + 2 = -3 (closestSum = -3)
  - currentSum < target, move left to 2
  - currentSum = -4 + 1 + 2 = -1 (closestSum = -1)
  - currentSum < target, move left to 3
  - Now left == right, we move to next i
- i=1 (nums[i]=-1), left=2, right=3
  - currentSum = -1 + 1 + 2 = 2 (closestSum = 2)
  - currentSum > target, move right to 2
  - Now left == right, we stop.
- The closest sum to target 1 is 2, so we return 2.