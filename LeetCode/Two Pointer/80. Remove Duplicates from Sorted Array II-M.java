https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

80. Remove Duplicates from Sorted Array II
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Solution:
class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=0;
        for(int val:nums){
            if(ind<2 || val>nums[ind-2]){
                nums[ind++]=val;
            }
        }
        return ind;
    }
}
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) since we are using only constant extra space.

Explanation:
1. We initialize an index ind to keep track of the position to insert the next valid element.
2. We iterate through each value in the nums array.
3. For each value, we check if ind is less than 2 (to allow the first two elements) or if the current value is greater than the element at position ind-2 (to ensure no more than two duplicates).
4. If either condition is true, we insert the current value at position ind and increment ind.
5. Finally, we return ind, which represents the length of the modified array with at most two duplicates for each unique element.
Explanation with Example:
Consider the input array nums = [1,1,1,2,2,3].
- Start with ind = 0.
- Iterate through each value in nums:
  - For the first 1: ind < 2, so insert 1 at nums[0], ind becomes 1.
  - For the second 1: ind < 2, so insert 1 at nums[1], ind becomes 2.
  - For the third 1: 1 is not greater than nums[0] (which is 1), so skip it.
  - For the first 2: 2 > nums[0] (which is 1), so insert 2 at nums[2], ind becomes 3.
  - For the second 2: 2 > nums[1] (which is 1), so insert 2 at nums[3], ind becomes 4.
  - For 3: 3 > nums[2] (which is 2), so insert 3 at nums[4], ind becomes 5.
- The modified array is now [1,1,2,2,3,_], and we return 5 as the length of the valid portion.