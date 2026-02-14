https://leetcode.com/problems/rotate-array/description/

189. Rotate Array
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Solution:-
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(0,n-k-1,nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
    
    }

    void swap(int i, int j, int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    void reverse(int left, int right, int[]nums){
        while(left<right && left>=0 && right<nums.length){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
}

Time Complexity: O(n) for reversing the array three times.
Space Complexity: O(1) since we are doing the rotation in-place without using any extra space.

Explanation:
1. We first calculate the effective number of rotations needed by taking k modulo n (the length of the array).
2. We then reverse the first n-k elements of the array, which will move the last k elements to the front.
3. Next, we reverse the last k elements of the array, which will put them in the correct order.
4. Finally, we reverse the entire array to get the final rotated array.
1. We define a helper function `swap` to swap two elements in the array.
2. We define another helper function `reverse` to reverse a portion of the array between the given left and right indices.
3. We call the `reverse` function three times to achieve the desired rotation of the array.
Example Walkthrough:
- Input: nums = [1,2,3,4,5,6,7], k = 3
- After calculating k % n, we get k = 3.
- We reverse the first n-k = 4 elements: [4,3,2,1,5,6,7]
- We reverse the last k = 3 elements: [4,3,2,1,7,6,5]
- We reverse the entire array: [5,6,7,1,2,3,4]
- Output: [5,6,7,1,2,3,4]