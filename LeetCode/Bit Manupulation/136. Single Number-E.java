https://leetcode.com/problems/single-number/description/

136. Single Number
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1

 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

Brute Force:-
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            } else{
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}

Time Complexity: O(n) for traversing the array once.
Space Complexity: O(n) in the worst case when all elements are unique.

Optimal Solution:-
class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        return xor;
    }
}
Time Complexity: O(n) for traversing the array once.
Space Complexity: O(1) as we are using only a constant amount of extra space.

Explanation:
1. The XOR operator (^) has a property that a ^ a = 0 and a ^ 0 = a. This means that if we XOR all the numbers in the array, the pairs of duplicate numbers will cancel each other out, leaving us with the single number that appears only once.
2. We initialize a variable xor to 0 and iterate through each number in the array, XORing it with xor. By the end of the loop, xor will hold the value of the single number that appears only once in the array.
3. Finally, we return the value of xor, which is the single number we are looking for.

Example Walkthrough:
1. Input: nums = [4,1,2,1,2]
   - We start with xor = 0.
   - XOR with 4: xor = 0 ^ 4 = 4
   - XOR with 1: xor = 4 ^ 1 = 5
   - XOR with 2: xor = 5 ^ 2 = 7
   - XOR with 1: xor = 7 ^ 1 = 6
   - XOR with 2: xor = 6 ^ 2 = 4
   - The final value of xor is 4, which is the single number that appears only once in the array.
2. Input: nums = [1]
   - We start with xor = 0.
   - XOR with 1: xor = 0 ^ 1 = 1
   - The final value of xor is 1, which is the single number that appears only once in the array.
3. Input: nums = [2,2,1]
   - We start with xor = 0.
   - XOR with 2: xor = 0 ^ 2 = 2
   - XOR with 2: xor = 2 ^ 2 = 0
   - XOR with 1: xor = 0 ^ 1 = 1
   - The final value of xor is 1, which is the single number that appears only once in the array.