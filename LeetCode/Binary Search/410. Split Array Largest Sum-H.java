https://leetcode.com/problems/split-array-largest-sum/description/

410. Split Array Largest Sum
Solved
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)

SOlution:
class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();
        while(low<high){
            int mid=(low+high)/2;
            if(isPossible(mid,k,nums)){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean isPossible(int subArraySum,int k, int[] nums){
        int noOfSubArray=1;
        int sum=0;
        for(int num:nums){
            if(sum+num>subArraySum){
                noOfSubArray++;
                sum=0;
            }
            sum+=num;
        }
        return noOfSubArray<=k;
    }
}

Time Complexity: O(n log m), where n is the number of elements in the input array `nums` and m is the difference between the maximum element in `nums` and the sum of all elements in `nums`. The binary search runs in O(log m) time, and for each mid value, we check if it's possible to split the array into k subarrays with a sum less than or equal to mid, which takes O(n) time.
Space Complexity: O(1) for the binary search and the helper function, as we are using only a constant amount of extra space to store variables. The input array `nums` is not modified, and we are not using any additional data structures that grow with the input size.