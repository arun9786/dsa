https://leetcode.com/problems/max-consecutive-ones-iii/description/

1004. Max Consecutive Ones III
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

Solution:
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,max=0,zeroCount=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We initialize two pointers, left and right, to represent the current window of the subarray. We also maintain a variable zeroCount to keep track of the number of 0s in the current window, and a variable max to keep track of the maximum length of valid subarrays found so far.
2. We iterate through the array using the right pointer. For each element, if it is 0, we increment the zeroCount.
3. If the zeroCount exceeds k, we move the left pointer to the right, decrementing the zeroCount if the element at the left pointer is 0, until the zeroCount is less than or equal to k.
4. For each position of the right pointer, we calculate the length of the current valid subarray (right - left + 1) and update max if this length is greater than the current max.
5. Finally, we return max, which contains the length of the longest subarray with at most k 0s.

Example Walkthrough:
Consider the input nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] and k = 2.
- Initialize left = 0, max = 0, zeroCount = 0.
- right = 0: nums[0] = 1, zeroCount = 0, max = 1 (subarray: [1])
- right = 1: nums[1] = 1, zeroCount = 0, max = 2 (subarray: [1, 1])
- right = 2: nums[2] = 1, zeroCount = 0, max = 3 (subarray: [1, 1, 1])
- right = 3: nums[3] = 0, zeroCount = 1, max = 4 (subarray: [1, 1, 1, 0])
- right = 4: nums[4] = 0, zeroCount = 2, max = 5 (subarray: [1, 1, 1, 0, 0])
- right = 5: nums[5] = 0, zeroCount = 3, zeroCount > k, move left:
    - left = 1: nums[0] = 1, zeroCount = 3
    - left = 2: nums[1] = 1, zeroCount = 3
    - left = 3: nums[2] = 1, zeroCount = 3
    - left = 4: nums[3] = 0, zeroCount = 2, max = 5 (subarray: [0, 0, 1, 1, 1, 1])
- right = 6: nums[6] = 1, zeroCount = 2, max = 6 (subarray: [0, 1, 1, 1, 1, 1])
- right = 7: nums[7] = 1, zeroCount = 2, max = 6 (subarray: [0, 1, 1, 1, 1, 1, 1])
- right = 8: nums[8] = 1, zeroCount = 2, max = 7 (subarray: [0, 1, 1, 1, 1, 1, 1, 1])
- right = 9: nums[9] = 1, zeroCount = 2, max = 8 (subarray: [0, 1, 1, 1, 1, 1, 1, 1, 1])
- right = 10: nums[10] = 0, zeroCount = 3, zeroCount > k, move left:
    - left = 5: nums[4] = 0, zeroCount = 2, max = 8 (subarray: [1, 1, 1, 1, 1, 1, 0])
finally, max = 6, which is the length of the longest subarray [1, 1, 1, 0, 0, 1, 1, 1, 1, 1] after flipping two 0s.