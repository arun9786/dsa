https://leetcode.com/problems/combination-sum-ii/description/

40. Combination Sum II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50

Solution:-

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,candidates,ans,new ArrayList<>(),target);
        return ans;
    }

    void recursion(int ind,int[] arr, List<List<Integer>> ans, List<Integer> temp,int target){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }        
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) return;
            temp.add(arr[i]);
            recursion(i+1,arr,ans,temp,target-arr[i]);
            temp.removeLast();
        }
    }
}
