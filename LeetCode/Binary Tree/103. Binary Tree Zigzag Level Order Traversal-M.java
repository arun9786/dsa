https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

103. Binary Tree Zigzag Level Order Traversal
Solved
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean leftToRight=true;
        while(!queue.isEmpty()){
            int n=queue.size();
            LinkedList<Integer> list=new LinkedList<>();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    list.offerLast(node.val);
                } else{
                    list.offerFirst(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            leftToRight=!leftToRight;
            ans.add(list);
        }
        return ans;

    }
}

Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node exactly once.
Space Complexity: O(n) in the worst case, when the tree is completely unbalanced .