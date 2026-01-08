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