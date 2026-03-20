https://leetcode.com/problems/symmetric-tree/description/

101. Symmetric Tree
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

1. BFS
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if(t1==null && t2==null) continue;
            if(t1==null || t2==null) return false;
            if(t1.val!=t2.val) return false;

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
Time Complexity: O(n), where n is the number of nodes in the tree.
Space Complexity: O(w), where w is the maximum width of the tree.

2. DFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1==null || t2==null){
            return false;
        }
        if(t1.val!=t2.val) return false;
        return dfs(t1.left,t2.right) && dfs(t1.right,t2.left);
    }
}

Time Complexity: O(n), where n is the number of nodes in the tree.
Space Complexity: O(h), where h is the height of the tree, which is O(log n) for a balanced tree and O(n) for a skewed tree.