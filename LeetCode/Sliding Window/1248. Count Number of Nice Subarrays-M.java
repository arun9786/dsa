https://leetcode.com/problems/count-number-of-nice-subarrays/submissions/1936588370/

1248. Count Number of Nice Subarrays
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

Solution:
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return noOfSubArrayslessThanOrEquals(nums,k) - noOfSubArrayslessThanOrEquals(nums,k-1);
    }

    public int noOfSubArrayslessThanOrEquals(int[] nums, int k){
        if(k<0) return 0;
        int n=nums.length;
        int l=0;
        int count=0;
        int oddCount=0;
        for(int r=0;r<n;r++){
            if(nums[r]%2!=0){
                oddCount++;
            }
            while(oddCount>k){
                if(nums[l]%2!=0){
                    oddCount--;
                }
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
}

Time complexity: O(n) where n is the length of the input array nums.
Space complexity: O(1) since we are using only a constant amount of extra space.