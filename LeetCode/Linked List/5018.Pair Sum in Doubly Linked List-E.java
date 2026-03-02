https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

5018.Pair Sum in Doubly Linked List
Difficulty: EasyAccuracy: 66.01%Submissions: 106K+Points: 2Average Time: 10m
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105

Solution:-
/* Structure for a Node of doubly linked list */
class Node {
    int data;
    Node next, prev;
    Node(int d) {
        data = d;
        next = prev = null;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(Node head, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node start = head;
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        while (start != end && end.next != start) {
            int sum = start.data + end.data;
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(start.data);
                pair.add(end.data);
                ans.add(pair);
                start = start.next;
                end = end.prev;
            } else if (sum < target) {
                start = start.next;
            } else {
                end = end.prev;
            }
        }
        return ans;
    }
}

Time Complexity: O(N) for traversing the list once.
Auxiliary Space: O(1) for using only a constant amount of space to store the pairs. The output space is not counted as auxiliary space.