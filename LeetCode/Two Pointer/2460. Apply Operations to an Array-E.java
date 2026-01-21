https://leetcode.com/problems/apply-operations-to-an-array/description/

2460. Apply Operations to an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed array nums of size n consisting of non-negative integers.

You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:

If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0s to the end of the array.

For example, the array [1,0,2,0,0,1] after shifting all its 0s to the end, is [1,2,1,0,0,0].
Return the resulting array.

Note that the operations are applied sequentially, not all at once.

 

Example 1:

Input: nums = [1,2,2,1,1,0]
Output: [1,4,2,0,0,0]
Explanation: We do the following operations:
- i = 0: nums[0] and nums[1] are not equal, so we skip this operation.
- i = 1: nums[1] and nums[2] are equal, we multiply nums[1] by 2 and change nums[2] to 0. The array becomes [1,4,0,1,1,0].
- i = 2: nums[2] and nums[3] are not equal, so we skip this operation.
- i = 3: nums[3] and nums[4] are equal, we multiply nums[3] by 2 and change nums[4] to 0. The array becomes [1,4,0,2,0,0].
- i = 4: nums[4] and nums[5] are equal, we multiply nums[4] by 2 and change nums[5] to 0. The array becomes [1,4,0,2,0,0].
After that, we shift the 0s to the end, which gives the array [1,4,2,0,0,0].
Example 2:

Input: nums = [0,1]
Output: [1,0]
Explanation: No operation can be applied, we just shift the 0 to the end.
 

Constraints:

2 <= nums.length <= 2000
0 <= nums[i] <= 1000

Solution:
class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int left=0;
        for(int right=0;right<n;right++){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
        return nums;
    }
}

Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We iterate through the array and for each element, we check if it is equal to the next element.
2. If they are equal, we double the current element and set the next element to 0.
3. After processing all elements, we use a two-pointer technique to move all non-zero elements to the front of the array while maintaining their order, and fill the rest of the array with zeros.
4. Finally, we return the modified array.
Explanation with Example:
Consider the input array nums = [1,2,2,1,1,0]
- We start by iterating through the array:
  - i = 0: nums[0] = 1, nums[1] = 2, not equal, do nothing.
  - i = 1: nums[1] = 2, nums[2] = 2, equal, set nums[1] = 4, nums[2] = 0, array becomes [1,4,0,1,1,0].
  - i = 2: nums[2] = 0, nums[3] = 1, not equal, do nothing.
  - i = 3: nums[3] = 1, nums[4] = 1, equal, set nums[3] = 2, nums[4] = 0, array becomes [1,4,0,2,0,0].
  - i = 4: nums[4] = 0, nums[5] = 0, equal, set nums[4] = 0, nums[5] = 0, array remains [1,4,0,2,0,0].
- Next, we move all non-zero elements to the front:
  - left = 0, right = 0: nums[0] = 1, swap with nums[0], left = 1.
  - right = 1: nums[1] = 4, swap with nums[1], left = 2.
  - right = 2: nums[2] = 0, do nothing.
  - right = 3: nums[3] = 2, swap with nums[2], array becomes [1,4,2,0,0,0], left = 3.
  - right = 4: nums[4] = 0, do nothing.
  - right = 5: nums[5] = 0, do nothing.
- The final array is [1,4,2,0,0,0].