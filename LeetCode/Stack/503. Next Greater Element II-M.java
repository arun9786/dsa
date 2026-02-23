https://leetcode.com/problems/next-greater-element-ii/description/

503. Next Greater Element II
Solved
Medium
Topics
premium lock icon
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109

Solution:-
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i]){
                stk.pop();
            }
            stk.push(nums[i]);
        }
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans[i]=-1;
            } else{
                ans[i]=stk.peek();
            }
            stk.push(nums[i]);
        }
        return ans;
    }
}

Time Complexity: O(2N) where N is the number of elements in the input array. Each element is pushed and popped from the stack at most once.
Space Complexity: O(2N) for the stack used to store the elements and O(N) for the output array, resulting in O(N) overall.