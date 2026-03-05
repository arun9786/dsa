https://leetcode.com/problems/binary-subarrays-with-sum/description/

930. Binary Subarrays With Sum
Medium
Topics
premium lock icon
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length

Solution:
Sliding window solution:-
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return noOfSubarrays(nums,goal)-noOfSubarrays(nums,goal-1);
    }

    public int noOfSubarrays(int[] nums,int goal){
        if(goal<0) return 0;
        int sum=0;
        int l=0;
        int count=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
}

Time complexity: O(n) where n is the length of the input array nums.
Space complexity: O(1) since we are using only a constant amount of extra space.



Map based solution:-
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int val:nums){
            prefixSum+=val;
            if(map.containsKey(prefixSum-goal)){
                count+=map.get(prefixSum-goal);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
Time complexity: O(n) where n is the length of the input array nums.
Space complexity: O(n) in the worst case, when all prefix sums are unique and stored in the map. In the best case, when all prefix sums are the same, the space complexity is O(1).