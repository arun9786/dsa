https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

111. Minimum Depth of Binary Tree
Solved
Easy
Topics
premium lock icon
Companies
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

Solution:
1. Recursion:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(root.left!=null){
            left=minDepth(root.left);
        }
        if(root.right!=null){
            right=minDepth(root.right);
        }
        return 1+Math.min(left,right);
    }
}
Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(N) in the worst case when the tree is completely unbalanced, and O(log N) in the best case when the tree is completely balanced.

2.Iteration:
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left==null && node.right==null){
                    return depth;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(N) in the worst case when the tree is completely unbalanced, and O(log N) in the best case when the tree is completely balanced.