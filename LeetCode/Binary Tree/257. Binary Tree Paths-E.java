https://leetcode.com/problems/binary-tree-paths/description/

257. Binary Tree Paths
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

Solution:-
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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return ans;
    }
    public void dfs(TreeNode node, String str){
        if(str.length()==0) str+=node.val;
        else str+="->"+node.val;
        if(node.left==null && node.right==null){
            ans.add(str);
        }
        if(node.left!=null){
            dfs(node.left,str);
        }
        if(node.right!=null){
            dfs(node.right,str);
        }
    }
}

Time Complexity: O(n)
Space Complexity: O(h)