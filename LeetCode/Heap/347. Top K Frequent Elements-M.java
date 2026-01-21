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
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        Queue<Integer> minHeap=new PriorityQueue<>(
            (a,b) -> map.get(a)-map.get(b)
        );
        for(int key:map.keySet()){
            if(minHeap.size()<k){
                minHeap.offer(key);
            } else if(map.get(key)>map.get(minHeap.peek())){
                minHeap.poll();
                minHeap.offer(key);
            }
        }
        int ans[]=new int[k];
        int ind=k-1;
        while(!minHeap.isEmpty()){
            ans[ind--]=minHeap.poll();
        }
        return ans;
    }
}

Time Complexity: O(N log K) - each insertion and deletion in the heap takes O(log K) time for N elements.
Space Complexity: O(N) - for the frequency map and the heap in the worst case.

Explanation:
1. We first create a frequency map to count the occurrences of each element in the input array nums.
2. We then use a min-heap (priority queue) to keep track of the top k frequent elements.
3. We iterate through the keys of the frequency map:
   - If the size of the heap is less than k, we add the current key to the heap.
   - If the size of the heap is equal to k and the frequency of the current key is greater than the frequency of the root of the heap (the least frequent among the top k), we remove the root and add the current key to the heap.
4. Finally, we extract the elements from the heap to form the result array.

Example Walkthrough:
For nums = [1,1,1,2,2,3] and k = 2:
- Frequency map: {1: 3, 2: 2, 3: 1}
- We add 1 to the heap: [1]
- We add 2 to the heap: [2, 1] (2 has frequency 2, 1 has frequency 3)
- We check 3: its frequency (1) is not greater than the root of the heap (2), so we skip it.
- The heap now contains the top 2 frequent elements: [2, 1].
- We extract them to get the result [1, 2] or [2, 1].