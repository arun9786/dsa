https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

1493. Longest Subarray of 1 s After Deleting One Element
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1 s in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1 s.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1 s is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Solution:
class Solution {
    public int longestSubarray(int[] nums) {
        int left=0,zeroCount=0,max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount>1){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max=Math.max(max,right-left);
        }
        return max;
    }
}
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We use a sliding window approach with two pointers, left and right, to maintain a window of elements in the array.
2. We also maintain a count of zeros (zeroCount) within the current window.
3. As we expand the right pointer, we increment zeroCount whenever we encounter a 0.
4. If zeroCount exceeds 1, we move the left pointer to the right until we have at most one 0 in the window, decrementing zeroCount as we move past zeros.
5. We calculate the maximum length of the window (right - left) at each step, which represents the longest subarray of 1s after deleting one element.
6. Finally, we return the maximum length found.

Example Walkthrough:
Consider the input array nums = [0,1,1,1,0,1,1,0,1]

- Initialize left = 0, zeroCount = 0, max = 0.
- right = 0: nums[0] = 0, zeroCount = 1, max = 0 (window: [0])
- right = 1: nums[1] = 1, zeroCount = 1, max = 1 (window: [0, 1])
- right = 2: nums[2] = 1, zeroCount = 1, max = 2 (window: [0, 1, 1])
- right = 3: nums[3] = 1, zeroCount = 1, max = 3 (window: [0, 1, 1, 1])
- right = 4: nums[4] = 0, zeroCount = 2. Since zeroCount > 1:
    - Move left pointer to the right until we have at most one zero in the window.
    - left becomes index of first zero in current window.
    - Now window is [1,1], and we continue.
- Continue this process for all elements in the array.
The longest subarray of 1s after deleting one element is of length 5, which occurs after deleting the 0 at index 4.