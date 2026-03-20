https://leetcode.com/problems/path-sum-ii/description/?envType=problem-list-v2&envId=binary-tree

113. Path Sum II
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,0,targetSum,new ArrayList<>(),ans);
        return ans;
    }

    public void dfs(TreeNode node,int sum,int target, List<Integer> temp,List<List<Integer>> ans){
        if(node==null) return;
        temp.add(node.val);
        sum+=node.val;
        if(node.left==null && node.right==null){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            temp.removeLast();
            return;
        }
        dfs(node.left,sum,target,temp,ans);
        dfs(node.right,sum,target,temp,ans);
        temp.removeLast();
    }
}

Time Complexity: O(n), where n is the number of nodes in the tree, as we visit each node once.
Space Complexity: O(h), where h is the height of the tree, as we store the path from the root to a leaf node in the recursive call stack. In the worst case, when the tree is skewed, h can be equal to n, resulting in O(n) space complexity.