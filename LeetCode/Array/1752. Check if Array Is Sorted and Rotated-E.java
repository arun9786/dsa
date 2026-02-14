https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

1752. Check if Array Is Sorted and Rotated
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

Solution:-
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}

Time Complexity: O(n) for traversing the array once.
Space Complexity: O(1) as we are using only a constant amount of extra space.

Explanation:
1. We initialize a counter `count` to keep track of the number of times we encounter a decrease in the order of the elements.
2. We loop through the array and compare each element with the next element (using modulo to wrap around to the beginning of the array).
3. If we find an element that is greater than the next element, we increment the `count`.
4. If at any point `count` exceeds 1, we can conclude that the array cannot be sorted and rotated, and we return false.
5. If we finish the loop and `count` is 0 or 1, it means the array is either already sorted or can be rotated to become sorted, so we return true.

Example Walkthrough:
1. Positive Case
    - Input: nums = [3,4,5,1,2]
    - We compare 3 and 4 (no increase), 4 and 5 (no increase), 5 and 1 (decrease, count=1), 1 and 2 (no increase), and 2 and 3 (no increase).
    - Since count is 1, we return true.
2. Negative Case
    - Input: nums = [2,1,3,4]
    - We compare 2 and 1 (decrease, count=1), 1 a ̰nd 3 (no increase), 3 and 4 (no increase), and 4 and 2 (decrease, count=2).
    - Since count exceeds 1, we return false.
3. Already Sorted Case
    - Input: nums = [1,2,3]
    - We compare 1 and 2 (no increase), 2 and 3 (no increase), and 3 and 1 (decrease, count=1).
    - Since count is 1, we return true.