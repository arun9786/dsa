https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

5005.Check if there exists a subsequence with sum K


Check if there exists a subsequence with sum K
Difficulty: MediumAccuracy: 40.26%Submissions: 63K+Points: 4Average Time: 30m
Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals the given target sum(k).


Example:

Input:  arr = [10,1,2,7,6,1,5], k = 8.
Output:  Yes
Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8

Input:  arr = [2,3,5,7,9], k = 100. 
Output:  No
Explanation:  No subsequence can sum upto 100
Your Task:
You dont need to read or print anything. Your task is to complete the boolean function checkSubsequenceSum() which takes N, arr and K as input parameter and returns true/false based on the whether any subsequence with sum K could be found.


Expected Time Complexity: O(N * K).
Expected Auxiliary Space: O(N * K).


Constraints:
1 <= arr.length <= 2000.
1 <= arr[i] <= 1000.
1 <= target <= 2000.

Solution:-

// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        return recursion(0,N,arr,K,0);
    }
    
    public static boolean recursion(int ind,int n,int[] arr,int K, int sum){
        if(sum>K) return false;
        if(ind==n){
            if(sum==K){
                return true;
            }
            return false;
        }
        sum+=arr[ind];
        if(recursion(ind+1,n,arr,K,sum)){
            return true;
        };
        sum-=arr[ind];
        if(recursion(ind+1,n,arr,K,sum)){
            return true;
        };
        return false;
    }
}

Time Complexity: O(2^N) as we are exploring all possible subsequences.
Space Complexity: O(N) for the recursion stack in the worst case when we explore all elements.