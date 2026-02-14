https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

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

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.

Solution:

class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=1;
        for(int val:nums){
            if(ind<1 || val>nums[ind-1]){
                nums[ind++]=val;
            }
        }
        return ind;
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            nums[ind++]=nums[i];
        }
        return ind;
    }
}
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) since we are using only constant extra space.

Explanation:
1. We initialize a pointer ind to 1, which will track the position to insert the next unique element.
2. We iterate through the array starting from the second element.
3. If the current element is different from the previous one, we place it at the index ind and increment ind.
4. Finally, we return ind, which represents the number of unique elements in the array.
Explanation with Example:
Consider the input array nums = [0,0,1,1,1,2,2,3,3,4]
- We start with ind = 1.
- We iterate through the array:
  - i = 1: nums[1] = 0, same as nums[0], continue.
  - i = 2: nums[2] = 1, different from nums[1], set nums[1] = 1, ind = 2.
  - i = 3: nums[3] = 1, same as nums[2], continue.
  - i = 4: nums[4] = 1, same as nums[3], continue.
  - i = 5: nums[5] = 2, different from nums[4], set nums[2] = 2, ind = 3.
  - i = 6: nums[6] = 2, same as nums[5], continue.
  - i = 7: nums[7] = 3, different from nums[6], set nums[3] = 3, ind = 4.
  - i = 8: nums[8] = 3, same as nums[7], continue.
  - i = 9: nums[9] = 4, different from nums[8], set nums[4] = 4, ind = 5.
- Finally, we return ind = 5, and the first five elements of nums are [0, 1, 2, 3, 4].