https://leetcode.com/problems/next-permutation/description/

31. Next Permutation
Solved
Medium
Topics
premium lock icon
Companies
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

Solution:
class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int right=n-2;
        while(right>=0 && nums[right]>=nums[right+1]){
            right--;
        }
        if(right>=0){
            int i=n-1;
            while(nums[i]<=nums[right]){
                i--;
            }
            swap(right,i,nums);    
        }
        reverse(right+1,n-1,nums);
    }

    public void swap(int i,int j, int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void reverse(int left,int right, int nums[]){
        while(left<right){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
}

Time Complexity: O(N) for traversing the array.
Space Complexity: O(1) as no extra space is used.

Explanation:
1. We start from the end of the array and look for the first decreasing element. This element is at index 'right'.
2. If such an element is found (i.e., right >= 0), we look for the first element from the end that is greater than nums[right].
3. We swap these two elements.
4. Finally, we reverse the subarray to the right of the 'right' index to get the next permutation in lexicographical order.
5. If no such element is found, it means the array is in descending order, and we simply reverse the entire array to get the smallest permutation.

explanation with example:
Consider the array [1, 3, 5, 4, 2].
1. We start from the end and find the first decreasing element. Here, 3 is the first decreasing element (index 1).
2. Next, we look for the first element from the end that is greater than 3, which is 4 (index 3).
3. We swap 3 and 4, resulting in the array [1, 4, 5, 3, 2].
4. Finally, we reverse the subarray to the right of index 1, which is [5, 3, 2], to get [2, 3, 5].
5. The final array is [1, 4, 2, 3, 5], which is the next permutation.