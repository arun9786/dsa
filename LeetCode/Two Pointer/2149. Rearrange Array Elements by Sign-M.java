https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

2149. Rearrange Array Elements by Sign
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
 

It is not required to do the modifications in-place.

Solution:
Brute Force approach:
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] rearranged=new int[nums.length];
        int posIndex=0;
        int negIndex=1;
        for(int num:nums){
            if(num>0){
                rearranged[posIndex]=num;
                posIndex+=2;
            }else{
                rearranged[negIndex]=num;
                negIndex+=2;
            }
        }
        return rearranged; 
    }
}

Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(n) for storing the rearranged array.

Explanation:
1. We initialize a new array rearranged of the same length as nums to store the rearranged elements.
2. We also initialize two pointers, posIndex and negIndex, to keep track of the next positions for positive and negative integers in the rearranged array. posIndex starts at 0 (the first position) and negIndex starts at 1 (the second position).
3. We iterate through each number in the input array nums. For each number:
   - If the number is positive, we place it at the current posIndex in the rearranged array and then increment posIndex by 2 to move to the next position for a positive integer.
   - If the number is negative, we place it at the current negIndex in the rearranged array and then increment negIndex by 2 to move to the next position for a negative integer.
4. After iterating through all numbers, we return the rearranged array, which now contains the elements in the required order.