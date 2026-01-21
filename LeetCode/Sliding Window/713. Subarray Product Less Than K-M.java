https://leetcode.com/problems/subarray-product-less-than-k/description/

713. Subarray Product Less Than K
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

Solution:
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int left=0,product=1,count=0;
        for(int right=0;right<nums.length;right++){
            product*=nums[right];
            while(product>=k){
                product/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We initialize two pointers, left and right, to represent the current window of the subarray. We also maintain a variable product to keep track of the product of elements in the current window, and a variable count to count the number of valid subarrays.
2. We iterate through the array using the right pointer. For each element, we multiply it to the product.
3. If the product becomes greater than or equal to k, we move the left pointer to the right, dividing the product by the element at the left pointer, until the product is less than k.
4. For each position of the right pointer, the number of valid subarrays that end at right is given by (right - left + 1). We add this to the count.
5. Finally, we return the count, which contains the total number of contiguous subarrays where the product of all elements is strictly less than k.

Example Walkthrough:
Consider the input nums = [10, 5, 2, 6] and k = 100.
- Initialize left = 0, product = 1, count = 0.
- right = 0: product = 10, count = 1 (subarray: [10])
- right = 1: product = 50, count = 3 (subarrays: [5], [10, 5])
- right = 2: product = 100, product >= k, move left:
    - left = 1: product = 10, count = 6 (subarrays: [2], [5, 2], [10, 5, 2])
- right = 3: product = 60, count = 8 (subarrays: [6], [2, 6], [5, 2, 6])
- Final count = 8.