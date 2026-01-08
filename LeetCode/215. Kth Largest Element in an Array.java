https://leetcode.com/problems/kth-largest-element-in-an-array/description/

215. Kth Largest Element in an Array
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104

Solution:-
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
       Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i:nums){
            if(minHeap.size()<k){
                minHeap.offer(i);
            } else if(i > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        return minHeap.peek();
    }
}

Time Complexity: O(N log K) - each insertion and deletion in the heap takes O(log K) time for N elements.
Space Complexity: O(K) - the heap stores at most K elements.