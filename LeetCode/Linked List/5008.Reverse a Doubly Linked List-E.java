https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
5008. Reverse a Doubly Linked List

Reverse a Doubly Linked List
Difficulty: EasyAccuracy: 70.38%Submissions: 211K+Points: 2Average Time: 15m
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104

Solution:-
/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node prev=null,next=null;
        Node current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            current.prev=next;
            prev=current;
            current=next;
        }
        return prev;
    }
}

Time Complexity: O(n) where n is the number of nodes in the doubly linked list.
Space Complexity: O(1) as we are using only constant extra space.