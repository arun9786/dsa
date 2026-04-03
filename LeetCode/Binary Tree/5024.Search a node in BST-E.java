https://www.geeksforgeeks.org/problems/search-a-node-in-bst/1

5024.Search a node in BST
Difficulty: EasyAccuracy: 68.46%Submissions: 115K+Points: 2Average Time: 15m
Given the root of a Binary Search Tree and a node value key, find if the node with value key is present in the BST or not.

Examples:

Input: root = [6, 2, 8, N, N, 7, 9], key = 8
    
Output: true
Explanation: 8 is present in the BST as right child of root.
Input: root = [16, 12, 18, 10, N, 17, 19], key = 14
    
Output: false
Explanation: 14 is not present in the BST
Constraints:
1 ≤ number of nodes ≤ 3*104
1 ≤ node->data, key ≤ 109

Solution:-
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean search(Node root, int key) {
        // code here
        Node ans=null;
        Node node=root;
        while(node!=null){
            if(node.data==key) return true;
            if(node.data<key) node=node.right;
            else node=node.left;
        }
        return false;
    }
}