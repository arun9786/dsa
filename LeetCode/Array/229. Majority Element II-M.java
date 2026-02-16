https://leetcode.com/problems/majority-element-ii/description/

229. Majority Element II
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?

Solution:
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        int count1=0,count2=0;
        int candidate1=0,candidate2=0;
        for(int num:nums){
            if(candidate1==num){
                count1++;
            }else if(candidate2==num){
                count2++;
            }else if(count1==0){
                candidate1=num;
                count1=1;
            }else if(count2==0){
                candidate2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==candidate1){
                count1++;
            }else if(num==candidate2){
                count2++;
            }
        }
        if(count1>n/3){
            result.add(candidate1);
        }
        if(count2>n/3){
            result.add(candidate2);
        }
        return result;
    }
}
Time Complexity: O(n) for finding the majority elements, as we need to iterate through the array twice. The first iteration is for finding the candidates, and the second iteration is for counting the occurrences of the candidates. Therefore, the total time complexity is O(n).
Space Complexity: O(1) for using only a constant amount of extra space to store the candidates and their counts.

Explanation:
1. We initialize an empty list called `result` to store the majority elements.
2. We determine the length of the input array `nums` and store it in variable `n`.
3. We initialize two count variables `count1` and `count2` to 0, and two candidate variables `candidate1` and `candidate2` to 0.
4. We iterate through each number in the `nums` array:
   - If the current number is equal to `candidate1`, we increment `count1`.
   - Else if the current number is equal to `candidate2`, we increment `count2`.
   - Else if `count1` is 0, we set `candidate1` to the current number and reset `count1` to 1.
   - Else if `count2` is 0, we set `candidate2` to the current number and reset `count2` to 1.
   - Else, we decrement both `count1` and `count2`.
5. After the first iteration, we have potential candidates for the majority elements in `candidate1` and `candidate2`.
6. We reset `count1` and `count2` to 0 and iterate through the `nums` array again to count the occurrences of `candidate1` and `candidate2`.
7. If `count1` is greater than n/3, we add `candidate1` to the `result` list.
8. If `count2` is greater than n/3, we add `candidate2` to the `result` list.
9. Finally, we return the `result` list, which contains all the majority elements that appear more than n/3 times in the array.

Example:
Input: nums = [3,2,3]
Output: [3]
- After the first iteration: candidate1 = 3, count1 = 2; candidate2 = 2, count2 = 1
- After the second iteration: count1 = 2, count2 = 1
- Since count1 > n/3, we add candidate1 (3) to the result list. Since count2 is not greater than n/3, we do not add candidate2 (2) to the result list. Final output: [3]
Input: nums = [1]
Output: [1]
- After the first iteration: candidate1 = 1, count1 = 1; candidate2 = 0, count2 = 0
- After the second iteration: count1 = 1, count2 = 0
- Since count1 > n/3, we add candidate1 (1) to the result list. Since count2 is not greater than n/3, we do not add candidate2 (0) to the result list. Final output: [1]
Input: nums = [1,2]
Output: [1,2]
- After the first iteration: candidate1 = 1, count1 = 1; candidate2 = 2, count2 = 1
- After the second iteration: count1 = 1, count2 = 1
- Since count1 > n/3, we add candidate1 (1) to the result list. Since count2 > n/3, we add candidate2 (2) to the result list. Final output: [1, 2]