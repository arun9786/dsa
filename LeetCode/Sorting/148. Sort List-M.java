https://leetcode.com/problems/sort-list/description/

148. Sort List
Solved
Medium
Topics
premium lock icon
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Solution:-

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
    public ListNode sortList(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        ListNode current=head;
        while(current!=null){
            list.add(current);
            current=current.next;
        }
        Collections.sort(list, (a,b)->a.val-b.val);
        ListNode newHead=new ListNode();
        current=newHead;
        for(ListNode node:list){
            current.next=node;
            current=current.next;
        }
        current.next=null;
        return newHead.next;
    }
}

Time Complexity: O(n log n) where n is the number of nodes in the linked list.
Space Complexity: O(n) for storing the nodes in the list.