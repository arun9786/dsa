https://leetcode.com/problems/contains-duplicate-ii/

219. Contains Duplicate II
Solved
Easy
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

Solution:
1.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int sub=Math.abs(i-map.get(nums[i]));
                if(sub<=k){
                    return true;
                }
            } 
            map.put(nums[i],i);
        }
        return false;
    }
}

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(N) for the hashmap.

2.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(min(N,K)) for the hashset.

