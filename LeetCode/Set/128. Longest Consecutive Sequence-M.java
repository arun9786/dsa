https://leetcode.com/problems/longest-consecutive-sequence/description/

128. Longest Consecutive Sequence
Solved
Medium
Topics
premium lock icon
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

Solution:-
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new LinkedHashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int max=0;
        for(int val:set){
            if(!set.contains(val-1)){
                int countMax=1;
                while(set.contains(val+1)){
                    countMax++;
                    val=val+1;
                }
                max=Math.max(countMax,max);
            }
            
        }
        return max;
    }
}

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(N) for the set to store the elements.