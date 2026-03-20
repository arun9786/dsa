https://leetcode.com/problems/binary-tree-right-side-view/description/

199. Binary Tree Right Side View
Solved
Medium
Topics
premium lock icon
Companies
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

SOlution:
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            ans.add(queue.peek().val);
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.right!=null) queue.offer(node.right);
                if(node.left!=null) queue.offer(node.left);
            }
        }
        return ans;
    }
}

Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node exactly once.
Space Complexity: O(w) where w is the maximum width of the tree, which in the worst case can be O(n/2) = O(n) for a complete binary tree.