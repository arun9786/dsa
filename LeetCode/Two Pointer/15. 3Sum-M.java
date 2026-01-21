https://leetcode.com/problems/3sum/description/

15. 3Sum
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

Solution:
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(right>left && nums[left]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if(sum>0){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return ans;
    }
}

Time Complexity: O(n^2) due to the nested loops after sorting.
Space Complexity: O(1) if we ignore the space required for the output list.

Explanation:
1. We first sort the input array to make it easier to avoid duplicates and use the two-pointer technique.
2. We iterate through the array, fixing one element at a time and using two pointers to find pairs that sum to the negative of the fixed element.
3. If we find a triplet that sums to zero, we add it to the result list and move the pointers while skipping duplicates.
4. We continue this process until we have checked all elements in the array.
Explanation with example::
Consider the input nums = [-1,0,1,2,-1,-4]
- After sorting, nums becomes [-4,-1,-1,0,1,2]
- We start with i=0 (nums[i]=-4), left=1, right=5
  - sum = -4 + (-1) + 2 = -3 (less than 0, move left)
  - left=2, sum = -4 + (-1) + 2 = -3 (less than 0, move left)
  - left=3, sum = -4 + 0 + 2 = -2 (less than 0, move left)
  - left=4, sum = -4 + 1 + 2 = -1 (less than 0, move left)
  - left=5, loop ends
- i=1 (nums[i]=-1), left=2, right=5
  - sum = -1 + (-1) + 2 = 0 (found triplet)
  - Add [-1,-1,2] to result, move left and right while skipping duplicates
  - left=3, right=4
  - sum = -1 + 0 + 1 = 0 (found triplet)
  - Add [-1,0,1] to result, move left and right while skipping duplicates
  - left=4, right=3, loop ends
- i=2 (nums[i]=-1), skip since its a duplicate
- i=3 (nums[i]=0), left=4, right=5
  - sum = 0 + 1 + 2 = 3 (greater than 0, move right)
  - right=4, loop ends
- Final result: [[-1,-1,2],[-1,0,1]]
