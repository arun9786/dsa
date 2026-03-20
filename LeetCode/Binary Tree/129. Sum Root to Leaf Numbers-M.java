https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

129. Sum Root to Leaf Numbers
Solved
Medium
Topics
premium lock icon
Companies
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.

Solution:
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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> nodeQueue= new LinkedList<>();
        Queue<Integer> sumQueue= new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        int sum=0;
        while(!nodeQueue.isEmpty()){
            TreeNode currNode=nodeQueue.poll();
            int currSum=sumQueue.poll();
            if(currNode.left==null && currNode.right==null){
                sum+=currSum;
            }
            if(currNode.left!=null){
                nodeQueue.offer(currNode.left);
                sumQueue.offer(currSum*10+currNode.left.val);
            }
            if(currNode.right!=null){
                nodeQueue.offer(currNode.right);
                sumQueue.offer(currSum*10+currNode.right.val);
            }
        }
        return sum;

    }
}

Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
Space Complexity: O(n) in the worst case when the tree is skewed, and O(log(n)) in the best case when the tree is balanced, due to the queues used for BFS

2. DFS

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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode node,int cSum){
        if(node==null) return;
        cSum=cSum*10+node.val;
        if(node.left==null && node.right==null){
            sum+=cSum;
            return;
        }
        dfs(node.left,cSum);
        dfs(node.right,cSum);   
    }
}

Time Complexity: O(n) where n is the number of nodes in the tree. We visit each node once.
Space Complexity: O(h) where h is the height of the tree. In the worst case, the tree is skewed and the height is n, so the space complexity is O(n). In the best case, the tree is balanced and the height is log(n), so the space complexity is O(log(n)).