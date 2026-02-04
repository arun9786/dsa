https://leetcode.com/problems/4sum/description/

18. 4Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

Solution:
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1,right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(right>left && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    } else if(sum<target){
                        left++;
                    } else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}

Time Complexity: O(N^3) where N is the length of the input array.
Space Complexity: O(1) if we dont consider the output list.

Explanation:
1. We first sort the input array to make it easier to avoid duplicates and use the two-pointer technique.
2. We use two nested loops to fix the first two numbers of the quadruplet.
3. For the remaining two numbers, we use the two-pointer technique to find pairs that sum to the required value (target - first number - second number).
4. We skip duplicates for all four numbers to ensure that the output contains only unique quadruplets.
5. We continue this process until we have checked all possible combinations.
Example Walkthrough:
Consider the input array: [1, 0, -1, 0, -2, 2] and target = 0
- After sorting: [-2, -1, 0, 0, 1, 2]
- Fix first number (-2) and second number (-1):
  - Use two pointers to find pairs that sum to 3 (0 - (-2) - (-1))
  - Found pair (1, 2) -> quadruplet: [-2, -1, 1, 2]
- Fix first number (-2) and second number (0):
  - Use two pointers to find pairs that sum to 2
  - Found pair (0, 2) -> quadruplet: [-2, 0, 0, 2]
- Fix first number (-1) and second number (0):
  - Use two pointers to find pairs that sum to 1
  - Found pair (0, 1) -> quadruplet: [-1, 0, 0, 1]
- The final output is [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]].