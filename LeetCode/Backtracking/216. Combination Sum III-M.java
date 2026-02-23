https://leetcode.com/problems/combination-sum-iii/description/

216. Combination Sum III
Solved
Medium
Topics
premium lock icon
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60

Solution:-
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]=new int[9];
        for(int i=0;i<9;i++){
            arr[i]=i+1;
        }
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,arr,k,ans,new ArrayList<>(),n);
        return ans;
    }

    void recursion(int ind,int[] arr, int k, List<List<Integer>> ans, List<Integer> temp,int target){
        if(temp.size()==k){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(arr[i]<=target){
                temp.add(arr[i]);
                recursion(i+1,arr,k,ans,temp,target-arr[i]);
                temp.removeLast();
            } else{
                break;
            }
        }
    }
}

Time Complexity: O(2^9) as we are generating all the subsets of the array of size 9. 
                 O(k * C(9, k)) where C(9, k) is the number of combinations of 9 items taken k at a time.
Space Complexity: O(k) for the recursion stack and the temporary list that holds the current combination