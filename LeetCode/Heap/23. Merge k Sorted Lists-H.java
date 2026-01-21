https://leetcode.com/problems/merge-k-sorted-lists/description/

23. Merge k Sorted Lists
Solved
Hard
Topics
premium lock icon
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

Solution:-
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap=new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );

        for(ListNode node:lists){
            if(node!=null){
                minHeap.offer(node);
            }
        }
        ListNode head=new ListNode();
        ListNode current=head ;
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            current.next=node;
            current=node;
            if(node.next!=null){
                minHeap.offer(node.next);
            }
        }
        return head.next;
    }
}

Time Complexity: O(N log k) where N is the total number of nodes across all lists and k is the number of lists.
Space Complexity: O(k) for the min heap.

Explanation:
1. We use a min-heap (priority queue) to efficiently get the smallest node among the heads of the k lists.
2. We initialize the min-heap with the head nodes of all non-empty lists.
3. We repeatedly extract the smallest node from the heap, add it to the merged list, and if that node has a next node, we insert the next node into the heap.
4. This process continues until the heap is empty, meaning all nodes have been merged into the final sorted list.

Explanation with Example:
Consider the input lists: [[1,4,5],[1,3,4],[2,6]]
- We start by adding the head nodes (1, 1, 2) to the min-heap.
- The heap now contains [1, 1, 2].
- We extract the smallest node (1 from the first list) and add it to the merged list. The merged list is now [1].
- We then add the next node (4) from the first list to the heap. The heap now contains [1, 2, 4].
- We repeat this process, always extracting the smallest node and adding its next node to the heap, until all nodes are merged.
- The final merged list will be [1, 1, 2, 3, 4, 4, 5, 6].