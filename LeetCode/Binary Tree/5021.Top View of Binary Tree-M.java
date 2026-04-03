https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

5021.Top View of Binary Tree

Difficulty: MediumAccuracy: 38.43%Submissions: 450K+Points: 4Average Time: 45m
You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note:

Return the nodes from the leftmost node to the rightmost node.
If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 
Examples:

Input: root = [1, 2, 3]
Output: [2, 1, 3]
Explanation: The Green colored nodes represents the top view in the below Binary tree.
 
Input: root = [10, 20, 30, 40, 60, 90, 100]
Output: [40, 20, 10, 30, 100]
Explanation: The Green colored nodes represents the top view in the below Binary tree.


Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Solution:-
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Object[]> queue=new LinkedList<>();
        queue.offer(new Object[]{root,0});
        while(!queue.isEmpty()){
            Object[] entry=queue.poll();
            Node node=(Node)entry[0];
            int col=(int)entry[1];
            if(!map.containsKey(col)){
                map.put(col,node.data);
            }
            if(node.left!=null){
                queue.offer(new Object[]{node.left,col-1});
            }
            if(node.right!=null){
                queue.offer(new Object[]{node.right,col+1});
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Integer val:map.values()){
            ans.add(val);
        }
        return ans;
    }
}

Time Complexity: O(nlogn), where n is the number of nodes in the tree. This is because we are using a TreeMap to store the nodes based on their horizontal distance, and inserting into a TreeMap takes O(logn) time.
Space Complexity: O(n), where n is the number of nodes in the tree. This is because in the worst case, we may have to store all the nodes in the queue and the Tree