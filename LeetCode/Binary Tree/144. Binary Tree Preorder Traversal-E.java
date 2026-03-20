https://leetcode.com/problems/binary-tree-preorder-traversal/description/

144. Binary Tree Preorder Traversal
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
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
1.
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return ans;
        }
        ans.add(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }
        return ans;
    }
}

2.class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        recursion(ans,root);
        return ans;
    }
    public void recursion(List<Integer> ans, TreeNode node){
        if(node==null) return;
        ans.add(node.val);
        recursion(ans,node.left);
        recursion(ans,node.right);
    }
}

Time Complexity: O(n) where n is the number of nodes in the binary tree. We visit each node exactly once.
Space Complexity: O(n) in the worst case when the binary tree is skewed (i.e., each node has only one child). In the best case of a balanced binary tree, the space complexity is O(log n) due to the recursive call stack.