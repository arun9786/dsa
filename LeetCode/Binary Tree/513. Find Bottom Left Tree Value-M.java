https://leetcode.com/problems/find-bottom-left-tree-value/description/

513. Find Bottom Left Tree Value
Solved
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

Solution:-
1. DFS
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
    int ans=-1;
    int maxHeight=-1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode node, int h){
        if(node==null) return;
        if(node.left==null && node.right==null){
            if(h>maxHeight){
                maxHeight=h;
                ans=node.val;
            }
            return;
        }
        dfs(node.left,h+1);
        dfs(node.right,h+1);
    }
}

Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree

2.BFS
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(i==0){
                    ans=node.val;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return ans;
    }
}
Time Complexity: O(n)
Space Complexity: O(n) in the worst case, when the tree is completely unbalanced .

2.
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode ansNode=null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ansNode=queue.poll();
            if(ansNode.right!=null) queue.offer(ansNode.right); 
            if(ansNode.left!=null) queue.offer(ansNode.left);
        }
        return ansNode.val;
    }
}
