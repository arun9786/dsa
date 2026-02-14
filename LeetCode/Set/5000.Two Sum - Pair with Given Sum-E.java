https://www.geeksforgeeks.org/problems/key-pair5616/1

Two Sum - Pair with Given Sum
Difficulty: EasyAccuracy: 30.61%Submissions: 452K+Points: 2Average Time: 20m
Given an array arr[] of integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

Examples:

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: arr[3] + arr[4] = -3 + 1 = -2
Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: None of the pair makes a sum of 0
Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[]
Constraints:
1 ≤ arr.size ≤ 105
-105 ≤ arr[i] ≤ 105
-2*105 ≤ target ≤ 2*105

Solution:
import java.util.HashSet;
class Solution {
    public boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr){
            if(set.contains(target-num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

Time Complexity: O(n) where n is the length of the input array arr.
Space Complexity: O(n) for storing the elements in the hash set.

Explanation:
1. We initialize an empty hash set to store the elements we have seen so far.
2. We iterate through each number in the input array arr.
3. For each number, we check if the complement (target - current number) exists in the hash set. If it does, it means we have found a pair of numbers that sum up to the target, and we return true.
4. If the complement does not exist in the hash set, we add the current number to the set and continue iterating.
5. If we finish iterating through the array without finding any pair that sums up to the target, we return false.

Example:
Input: arr[] = [0, -1, 2, -3, 1], target = -2
- We start with an empty hash set.
- We iterate through the array:
  - For 0: complement is -2 (not in set), add 0 to set.
  - For -1: complement is -1 (not in set), add -1 to set.
  - For 2: complement is -4 (not in set), add 2 to set.
  - For -3: complement is 1 (not in set), add -3 to set.
  - For 1: complement is -3 (in set), return true.
Input: arr[] = [1, -2, 1, 0, 5], target = 0
- We start with an empty hash set.
- We iterate through the array:
  - For 1: complement is -1 (not in set), add 1 to set.
  - For -2: complement is 2 (not in set), add -2 to set.
  - For 1: complement is -1 (not in set), add 1 to set.
  - For 0: complement is 0 (not in set), add 0 to set.
  - For 5: complement is -5 (not in set), add 5 to set.
- We finish iterating without finding any pair that sums up to 0, return false.
Input: arr[] = [11], target = 11
- We start with an empty hash set.
- We iterate through the array:
  - For 11: complement is 0 (not in set), add 11 to set.
- We finish iterating without finding any pair that sums up to 11, return false