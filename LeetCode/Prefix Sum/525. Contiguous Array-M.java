https://leetcode.com/problems/contiguous-array/description/

525. Contiguous Array
Solved
Medium
Topics
premium lock icon
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Solution:
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==1?1:-1);
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            } else{
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}

Time Complexity: O(N) where N is the length of the input array.
Space Complexity: O(N) where we are using a hashmap to store the prefix sums.

Explanation:
1. We can convert all 0s in the array to -1s. This way, we need to find the longest subarray with a sum of 0.
2. We maintain a prefix sum while iterating through the array. If we encounter the same prefix sum again, it means the subarray between the two indices has a sum of 0.
3. We use a hashmap to store the first occurrence of each prefix sum. If we find the same prefix sum again, we calculate the length of the subarray and update the maximum length if needed.

Example Walkthrough:
Consider the input array: [0, 1, 0, 1, 1, 0]
- Convert 0s to -1s: [-1, 1, -1, 1, 1, -1]
- Initialize sum = 0, maxLen = 0, and map = {0: -1}
- Iterate through the array:
  - i = 0: sum = -1, map = {0: -1, -1: 0}
  - i = 1: sum = 0, maxLen = 2 (from index 0 to 1)
  - i = 2: sum = -1, maxLen = 2 (from index 1 to 2)
  - i = 3: sum = 0, maxLen = 4 (from index 0 to 3)
  - i = 4: sum = 1, map = {0: -1, -1: 0, 1: 4}
  - i = 5: sum = 0, maxLen = 6 (from index 0 to 5)
- The final result is maxLen = 6.