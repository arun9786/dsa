https://leetcode.com/problems/binary-tree-postorder-traversal/description/

145. Binary Tree Postorder Traversal
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?

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
1. Recursive Solution
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        recursion(ans,root);
        return ans;
    }

    public void recursion(List<Integer> ans,TreeNode node){
        if(node==null) return;
        recursion(ans,node.left);
        recursion(ans,node.right);
        ans.add(node.val);
    }
}

Time Complexity: O(n) where n is the number of nodes in the tree.
Space Complexity: O(n) in the worst case when the tree is skewed, otherwise O(log n) for a balanced tree.

2. 
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return ans;
        }
        if(root.left!=null){
            postorderTraversal(root.left);
        }
         if(root.right!=null){
            postorderTraversal(root.right);
        }
        ans.add(root.val);
        return ans;
    }
}

3.