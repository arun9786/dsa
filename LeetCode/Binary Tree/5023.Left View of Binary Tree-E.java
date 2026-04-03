https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

5023.Left View of Binary Tree
Difficulty: EasyAccuracy: 33.74%Submissions: 598K+Points: 2Average Time: 20m
Given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

Note: If the tree is empty, return an empty list.

Examples :

Input: root = [1, 2, 3, 4, 5, N, N]

Output:[1, 2, 4]
Explanation: From the left side of the tree, only the nodes 1, 2, and 4 are visible.

Input: root = [1, 2, 3, N, N, 4, N, N, 5, N, N]

Output: [1, 2, 4, 5]
Explanation: From the left side of the tree, only the nodes 1, 2, 4, and 5 are visible.

Constraints:
0 ≤ number of nodes ≤ 105
0 ≤ node -> data ≤ 105


Solution:-
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            ans.add(queue.peek().data);
            for(int i=0;i<n;i++){
                Node node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return ans;
    }
}

Time Complexity: O(N), where N is the number of nodes in the binary tree.
Space Complexity: O(N), where N is the number of nodes in the binary tree, as in the worst case, we might have to store all the nodes in the queue (for example, in the case of a complete binary tree).
