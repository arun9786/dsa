https://leetcode.com/problems/combination-sum/description/

39. Combination Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

Solution:-

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,candidates.length,candidates,0,target,ans,new ArrayList<>());
        return ans;
    }

    void recursion(int ind,int n, int[] arr,int sum,int target,List<List<Integer>> ans,List<Integer> temp){
        if(ind==n){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(sum+arr[ind]<=target){
            temp.add(arr[ind]);
            sum+=arr[ind];
            recursion(ind,n,arr,sum,target,ans,temp);
            sum-=arr[ind];
            temp.removeLast();
        }
        recursion(ind+1,n,arr,sum,target,ans,temp);
    }
}

Time Complexity: O(2^T) where T is the target value, as in the worst case we can have all combinations of numbers that sum up to target.
Space Complexity: O(T) for the recursion stack and the temporary list that holds the current combination.
