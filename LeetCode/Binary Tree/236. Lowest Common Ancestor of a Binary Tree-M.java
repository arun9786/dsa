https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

236. Lowest Common Ancestor of a Binary Tree
Solved
Medium
Topics
premium lock icon
Companies
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

Solution:-
1.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;

        return root;
    }
}

Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case, we might have to visit all nodes of the tree.
Space Complexity: O(N), where N is the number of nodes in the binary tree. This space is used by the recursion stack in the worst case when the tree is skewed.


2.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPathList=new ArrayList<>();
        pathToNode(root,p,pPathList);
        List<TreeNode> qPathList=new ArrayList<>();
        pathToNode(root,q,qPathList);
        int n=pPathList.size();
        int m=qPathList.size();
        int i=0;
        TreeNode ans=null;
        while(i<n && i<m){
            if(pPathList.get(i)!=qPathList.get(i)){
                break;
            }
            ans=pPathList.get(i);
            i++;
        }
        return ans;
    }

    public boolean pathToNode(TreeNode node, TreeNode target,List<TreeNode> list){
        if(node==null) return false;
        list.add(node);
        if(node==target) return true;
        if( pathToNode(node.left,target,list) ||
        pathToNode(node.right,target,list)){
            return true;
        }
        list.removeLast();    
        return false;                        
    }
}

Time Complexity: O(N), where N is the number of nodes in the binary tree.
Space Complexity: O(N), where N is the number of nodes in the binary tree. This space is used to store the path from the root to the target nodes p and q. In the worst case, when the tree is skewed, the path can contain all nodes in the tree.
