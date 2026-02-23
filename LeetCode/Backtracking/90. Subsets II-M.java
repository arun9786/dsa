https://leetcode.com/problems/subsets-ii/description/

90. Subsets II
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

Solution:-

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,nums,ans,new ArrayList<>());
        return ans;
    }

    void recursion(int ind,int[] arr, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            temp.add(arr[i]);
            recursion(i+1,arr,ans,temp);
            temp.removeLast();
        }
    }
}

Time Complexity: O(N*2^N) where N is the number of elements in the input array. This is because there are 2^N subsets and generating each subset takes O(N) time.
Space Complexity: O(N) for the recursion stack and O(N) for the temporary list used to store the current subset, resulting in O(N) overall. The space required to store the final answer is not considered in this analysis.