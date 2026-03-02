https://leetcode.com/problems/remove-linked-list-elements/description/

203. Remove Linked List Elements
Solved
Easy
Topics
premium lock icon
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

Solution:-
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val){
            head=head.next;
        }
        ListNode current=head;
        while(current!=null && current.next!=null){
            if(current.next.val==val){
                current.next=current.next.next;
            } else{
                current=current.next;
            }
        }
        return head;
    }
}

Time Complexity: O(n) where n is the number of nodes in the linked list, as we need to traverse the entire list once.
Space Complexity: O(1) as we are using only a constant amount of extra space.