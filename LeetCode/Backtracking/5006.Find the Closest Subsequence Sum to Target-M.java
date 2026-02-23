
5006.Find the Closest Subsequence Sum to Target

Given an integer array arr[] and an integer target. The task is to find a subsequence of arr such that the absolute difference between the sum of its elements and target is minimized. Return the minimum possible value of abs(sum - target).

Note: Subsequence of an array is an array formed by removing some (possibly all or none) of the original elements.

Examples:

Input: arr = [5, -7, 3, 5], target = 6
Output: 0
Explanation: Choose the whole array as a subsequence, with a sum of 6. This is equal to the target, so the absolute difference is 0.


Input: arr = [1, 2, 3], target = -7
Output: 7
Explanation: Choosing no elements results in a sum of 0, which is the closest to -7.

Solution:-
class Solution {
    static int closetSum(int[] arr,int target){
        //code here
        return recursion(0,arr.length,arr,0,target);
    }

    static int recursion (int ind, int n, int[] arr, int sum, int target){
        if(ind==n){
            return Math.abs(sum-target);
        }

        sum+=arr[ind];
        int left = recursion(ind+1,n,arr,sum,target);
        sum-=arr[ind];
        int right = recursion(ind+1,n,arr,sum,target);
        return Math.min(left,right);

    }
}

Time Complexity: O(2^N) as we are exploring all possible subsequences.
Space Complexity: O(N) as we are using recursion stack space.