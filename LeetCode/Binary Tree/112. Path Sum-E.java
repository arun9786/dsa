https://leetcode.com/problems/path-sum/description/

112. Path Sum
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

Solution:
1.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }

    public boolean dfs(TreeNode node,int sum,int targetSum){
        if(node==null) return false;
        sum+=node.val;
        if(node.left==null && node.right==null){
            if(sum==targetSum) return true;
            else return false;
        }
        return dfs(node.left,sum,targetSum) || dfs(node.right,sum,targetSum);
    }
}
Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
Space Complexity:O(h) where h is the height of the tree. In the worst case, the tree is skewed and the height is O(n), leading to O(n) space complexity. In the best case, the tree is balanced and the height is O(log n), leading to O(log n) space complexity.
2.
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }

    public boolean dfs(TreeNode node,int sum,int targetSum){
        if(node==null) return false;
        sum+=node.val;
        if(node.left==null && node.right==null){
            if(sum==targetSum) return true;
            else return false;
        }
        boolean left=dfs(node.left,sum,targetSum);
        if(left) return true;
        boolean right =dfs(node.right,sum,targetSum);
        if(right) return true;
        return  left || right;
    }
}