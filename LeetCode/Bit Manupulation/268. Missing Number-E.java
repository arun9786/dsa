https://leetcode.com/problems/missing-number/description/

268. Missing Number
Solved
Easy
Topics
premium lock icon
Companies
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Solution:-
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum=n*(n+1)/2;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return totalSum-sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=i;
            xor^=nums[i];
        }
        xor^=nums.length;
        return xor;
    }
}

Time Complexity: O(n) for traversing the array once.
Space Complexity: O(1) as we are using only a constant amount of extra space.

Explanation:
1. In the first solution, we calculate the total sum of numbers from 0 to n using the formula n*(n+1)/2 and then subtract the sum of the elements in the array to find the missing number.
2. In the second solution, we use the XOR operation to find the missing number. We XOR all the indices and all the numbers in the array. Since XOR of a number with itself is 0 and XOR of a number with 0 is the number itself, the result will be the missing number after XORing all indices and numbers.
Example Walkthrough:
Consider the input array nums = [3,0,1]
- For the first solution:
  - n = 3, totalSum = 3*(3+1)/2 = 6
  - sum = 3 + 0 + 1 = 4
  - missing number = totalSum - sum = 6 - 4 = 2
- For the second solution:
  - Initialize xor = 0
  - i = 0: xor = 0 ^ 0 ^ 3 = 3
  - i = 1: xor = 3 ^ 1 ^ 0 = 2
  - i = 2: xor = 2 ^ 2 ^ 1 = 0
  - After the loop, xor = 0 ^ 3 (length of the array) = 2
  - missing number = xor = 2
