https://leetcode.com/problems/subarrays-with-k-different-integers/description/

992. Subarrays with K Different Integers
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length

Solution:
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctleasThanOrEquals(nums,k) - subarraysWithKDistinctleasThanOrEquals(nums,k-1);
    }

    public int subarraysWithKDistinctleasThanOrEquals(int[] nums,int k){
        if(k<0) return 0;
        int n=nums.length;
        int count=0;
        int l=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int r=0;r<n;r++){
            int val=nums[r];
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                int lval=nums[l];
                map.put(lval,map.get(lval)-1);
                if(map.get(lval)==0){
                    map.remove(lval);
                }
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
}

Time Complexity: O(n) where n is the length of the input array nums. We traverse the array once with the right pointer and the left pointer moves at most n times in total.
Space Complexity: O(k) where k is the number of different integers allowed in the subarrays. In the worst case, the map can contain up to k different integers.