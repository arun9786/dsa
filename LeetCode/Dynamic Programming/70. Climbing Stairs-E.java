https://leetcode.com/problems/climbing-stairs/

70. Climbing Stairs
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

Solution:
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp= new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
Time Complexity: O(n)
Space Complexity: O(n)

class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;arr[1]=1;
        return stairs(n,arr);
    }

    public int stairs(int n, int arr[]){
        if(arr[n]!=0) return arr[n];
        return arr[n]=stairs(n-1,arr)+stairs(n-2,arr);
    }
}
Time Complexity: O(n)
Space Complexity: O(n) due to recursion stack and dp array.