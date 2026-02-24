https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

5015.Add 1 to a Linked List Number

Add 1 to a Linked List Number
Difficulty: MediumAccuracy: 31.91%Submissions: 355K+Points: 4Average Time: 20m
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 9

Solution:-
c/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        Node backup=head;
        Node r1=reverse(head);
        Node temp=r1;
        int carry=0;
        while(temp!=null){
            if(temp.data==9){
                temp.data=0;
                carry=1;
                temp=temp.next;
            }else{
                temp.data=temp.data+1;
                carry=0;
                break;
            }
        }
        Node r2=reverse(r1);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=r2;
            r2=newNode;
        }
        return r2;
    }
    
    Node reverse(Node head){
        Node prev=null;
        Node temp=head;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}

Time Complexity: O(3N) where N is the number of nodes in the linked list. We traverse the linked list three times: once to reverse it, once to add one, and once more to reverse it back.
Space Complexity: O(1) as we are modifying the linked list in place and not using any additional data structures that grow with the input size.

Optimal Solution:-
class Solution {
    public Node addOne(Node head) {
        Node dummy=new Node(0);
        dummy.next=head;
        Node nonNineNode=dummy;
        Node temp=head;
        while(temp!=null){
            if(temp.data!=9){
                nonNineNode=temp;
            }
            temp=temp.next;
        }
        nonNineNode.data++;
        Node nxt=nonNineNode.next;
        while(nxt!=null){
            nxt.data=0;
            nxt=nxt.next;
        }
        return dummy.data==1?dummy:dummy.next;
    }
}
Time Complexity: O(N) where N is the number of nodes in the linked list. We traverse the linked list once to find the rightmost non-nine node and then again to set the following nodes to zero if needed.
Space Complexity: O(1) as we are modifying the linked list in place and using only a constant amount of extra space for the dummy node and pointers.