https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

5009. Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 287K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2

Solution:-
/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zeroHead =new Node(-1);
        Node oneHead =new Node(-1);
        Node twoHead =new Node(-1);
        Node zero=zeroHead,one=oneHead,two=twoHead;
        Node current=head;
        while(current!=null){
            if(current.data==0){
                zero.next=current;
                zero=current;
            } else if(current.data==1){
                one.next=current;
                one=current;
            } else{
                two.next=current;
                two=current;
            }
            current=current.next;
        }
        zero.next=(oneHead.next==null)?twoHead.next:oneHead.next;
        one.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
}

Time Complexity: O(n) where n is the number of nodes in the linked list.
Space Complexity: O(1) as we are using only constant extra space.