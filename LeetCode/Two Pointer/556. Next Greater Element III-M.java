https://leetcode.com/problems/next-greater-element-iii/description/

556. Next Greater Element III
Solved
Medium
Topics
premium lock icon
Companies
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1

Solution:-
class Solution {
    public int nextGreaterElement(int n) {
        char[] nums=String.valueOf(n).toCharArray();
        int len=nums.length;
        int right=len-2;
        while(right>=0 && nums[right]>=nums[right+1]){
            right--;
        }
        if(right>=0){
            int i=len-1;
            while(nums[i]<=nums[right]){
                i--;
            }
            swap(right,i,nums);
        }
        reverse(right+1,len-1,nums);
        long newNumber=Long.parseLong(new String(nums));
        if(newNumber>Integer.MAX_VALUE || newNumber<=n){
            return -1;
        }
        return (int)newNumber;
    }

    void swap(int i,int j,char[] nums){
        char temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    void reverse(int left,int right,char nums[]){
        while(left<right){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
}

Time Complexity: O(n) where n is the number of digits in the given number. This is because we are traversing the digits of the number at most twice (once to find the rightmost pair of digits and once to reverse the suffix).
Space Complexity: O(n) for storing the digits of the number in a character array. The space required to store the final answer is not considered in this analysis.