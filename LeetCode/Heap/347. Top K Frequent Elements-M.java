https://leetcode.com/problems/top-k-frequent-elements/description/

347. Top K Frequent Elements
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Solution:-
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int val:nums){
            countMap.put(val,countMap.getOrDefault(val,0)+1);
        }
        Queue<Integer> minHeap=new PriorityQueue<>(
            (a,b) -> countMap.get(a)-countMap.get(b)
        );
        for(Integer key:countMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[]ans=new int[k];
        int index=0;
        while(!minHeap.isEmpty()){
            ans[index++]=minHeap.poll();
        }
        return ans;
    }
}

Time Complexity: O(N log K) - each insertion and deletion in the heap takes O(log K) time for N elements.
Space Complexity: O(N) - for the frequency map and the heap in the worst case.