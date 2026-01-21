https://leetcode.com/problems/squares-of-a-sorted-array/description/

977. Squares of a Sorted Array
Solved
Easy
Topics
premium lock icon
Companies
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

Solution:-
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int left=0,right=nums.length-1;
        int ind=n-1;
        int result[]=new int[n];
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[ind--]=nums[left]*nums[left];
                left++;
            } else{
                result[ind--]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
Time Complexity: O(n) for single pass through the array.
Space Complexity: O(n) for the output array.

Explanation:
1. We initialize two pointers, left at the start and right at the end of the array.
2. We also initialize an index ind at the end of the result array where we will place the largest squares.
3. We compare the absolute values of the elements at the left and right pointers.
4. We place the square of the larger absolute value at the current index in the result array and move the corresponding pointer inward.
5. We repeat this process until the left pointer exceeds the right pointer.
6. Finally, we return the result array containing the squares in sorted order.

Explanation with Example:
Consider the input array nums = [-4,-1,0,3,10]
- We start with left = 0 (nums[left] = -4), right = 4 (nums[right] = 10), ind = 4
  - | -4 | < | 10 |, so we place 10^2 = 100 at result[4], right = 3, ind = 3
- Now left = 0 (nums[left] = -4), right = 3 (nums[right] = 3), ind = 3
  - | -4 | > | 3 |, so we place (-4)^2 = 16 at result[3], left = 1, ind = 2
- Now left = 1 (nums[left] = -1), right = 3 (nums[right] = 3), ind = 2
  - | -1 | < | 3 |, so we place 3^2 = 9 at result[2], right = 2, ind = 1
- Now left = 1 (nums[left] = -1), right = 2 (nums[right] = 0), ind = 1
  - | -1 | > | 0 |, so we place (-1)^2 = 1 at result[1], left = 2, ind = 0
- Now left = 2 (nums[left] = 0), right = 2 (nums[right] = 0), ind = 0
  - | 0 | <= | 0 |, so we place 0^2 = 0 at result[0], right = 1, ind = -1
- Now left > right, we stop.
- The final result array is [0, 1, 9, 16, 100].