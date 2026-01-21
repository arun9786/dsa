https://leetcode.com/problems/merge-sorted-array/description/

88. Merge Sorted Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

Solution:
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int li=m-1,ri=n-1,ti=m+n-1;
        while(li>=0 && ri>=0){
            if(nums2[ri]>=nums1[li]){
                nums1[ti--]=nums2[ri];
                ri--;
            } else{
                nums1[ti--]=nums1[li];
                li--;
            }
        }
        while(ri>=0){
            nums1[ti--]=nums2[ri];
            ri--;
        }
        while(li>=0){
            nums1[ti--]=nums1[li];
            li--;
        }
    }
}

Time Complexity: O(m + n) where m and n are the lengths of nums1 and nums2 respectively.
Space Complexity: O(1) as we are merging in-place without using any extra space.

Explanation:
1. We initialize three pointers: li for the last element of the first m elements in nums1, ri for the last element of nums2, and ti for the last position in nums1 where we will place the largest element.
2. We compare the elements pointed by li and ri, placing the larger one at the position pointed by ti, and then move the respective pointers accordingly.
3. After one of the arrays is exhausted, we copy any remaining elements from nums2 to nums1 (if any).
4. The remaining elements in nums1 are already in place, so no further action is needed for them.

Explanation with Example:
Consider the input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3
- Initialize li = 2 (pointing to 3), ri = 2 (pointing to 6), ti = 5 (last index of nums1)
- Compare nums1[li] and nums2[ri]:
  - 3 < 6, so place 6 at nums1[ti], now nums1 = [1,2,3,0,0,6], ti = 4, ri = 1
- Compare nums1[li] and nums2[ri]:
  - 3 < 5, so place 5 at nums1[ti], now nums1 = [1,2,3,0,5,6], ti = 3, ri = 0
- Compare nums1[li] and nums2[ri]:
  - 3 >= 2, so place 3 at nums1[ti], now nums1 = [1,2,3,3,5,6], ti = 2, li = 1
- Compare nums1[li] and nums2[ri]:
  - 2 >= 2, so place 2 at nums1[ti], now nums1 = [1,2,2,3,5,6], ti = 1, li = 0
- Compare nums1[li] and nums2[ri]:
  - 1 < 2, so place 2 at nums1[ti], now nums1 = [1,2,2,3,5,6], ti = 0, ri = -1
- Now ri < 0, so we stop. The final merged array is nums1 = [1,2,2,3,5,6].