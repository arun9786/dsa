https://leetcode.com/problems/sum-of-subarray-minimums/description/


Code
Testcase
Testcase
Test Result
907. Sum of Subarray Minimums
Solved
Medium
Topics
premium lock icon
Companies
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

Solution:
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stk=new Stack<>();
        long result=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                left[i]=i+1;
            } else{
                left[i]=i-stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                right[i]=n-i;
            } else{
                right[i]=stk.peek()-i;
            }
            stk.push(i);
        }

        for(int i=0;i<n;i++){
            result=(result+(long)left[i]*right[i]*arr[i])%mod;
        }
        return (int)result;
    }
}

Time Complexity: O(3N) where N is the length of the input array. We traverse the array twice to fill the left and right arrays, and then once more to calculate the result.
Space Complexity: O(2N) for the left and right arrays, and O(N) for the stack in the worst case.