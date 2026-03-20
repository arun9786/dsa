https://leetcode.com/problems/diameter-of-binary-tree/description/

543. Diameter of Binary Tree
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

Solution:
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
    Integer diameter=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    public int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        diameter=Math.max(diameter,1+left+right);
        return 1+Math.max(left,right);
    }
}

Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once to calculate its height and update the diameter.
Space Complexity: O(h) where h is the height of the tree. In the worst case, the tree is skewed and the height is equal to the number of nodes, resulting in O(n) space complexity. In the best case, the tree is balanced and the height is log(n), resulting in O(log(n)) space complexity.