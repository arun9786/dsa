https://leetcode.com/problems/sum-of-subarray-ranges/description/

2104. Sum of Subarray Ranges
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109


Solution:-
class Solution {
    public long subArrayRanges(int[] nums) {
        return subOfSubarrayMaximum(nums)-subOfSubarrayMinimum(nums);
    }

    public long subOfSubarrayMaximum(int[] nums){
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        long result=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]<=nums[i]){
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
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i]){
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
            result+=((long)left[i]*right[i]*nums[i]);
        }
        return result;
    }

    public long subOfSubarrayMinimum(int[] nums){
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        long result=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
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
            while(!stk.isEmpty() && nums[stk.peek()]>nums[i]){
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
            result+=((long)left[i]*right[i]*nums[i]);
        }
        return result;
    }
}

Time Complexity: O(N) where N is the length of the input array. Each element is pushed and popped at most once in both the maximum and minimum calculations.
Space Complexity: O(N) in the worst case when the stack contains all elements of the array, and O(N) for the left and right arrays in both calculations.