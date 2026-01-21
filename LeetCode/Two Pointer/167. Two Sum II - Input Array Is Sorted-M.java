https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1884831617/

167. Two Sum II - Input Array Is Sorted
Solved
Medium
Topics
premium lock icon
Companies
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.

Solution:
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            } else if(sum>target){
                right--;
            } else{
                left++;
            }
        }
        return new int[]{};
    }
}

Time Complexity: O(n) where n is the length of the input array numbers.
Space Complexity: O(1) since we are using only constant extra space.

Explanation:
1. We initialize two pointers, left at the start and right at the end of the array.
2. We calculate the sum of the elements at these two pointers.
3. If the sum equals the target, we return the indices (1-indexed).
4. If the sum is greater than the target, we move the right pointer to the left to decrease the sum.
5. If the sum is less than the target, we move the left pointer to the right to increase the sum.
6. We repeat this process until we find the two numbers that add up to the target.
Explanation with example::
Consider the input numbers = [2,7,11,15], target = 9
- Initialize left = 0, right = 3 (last index)
- Calculate sum: 2 + 15 = 17, which is greater than target (9), so move right pointer to 2
- Calculate sum: 2 + 11 = 13, which is greater than target (9), so move right pointer to 1
- Calculate sum: 2 + 7 = 9, which equals target (9), so return [1, 2] (1-indexed)
- The output is [1, 2] since the numbers at these indices add up to the target.