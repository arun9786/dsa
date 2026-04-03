https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

5022.Bottom View of Binary Tree
Difficulty: MediumAccuracy: 54.18%Submissions: 347K+Points: 4Average Time: 45m
You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

Examples :

Input: root = [1, 2, 3, 4, 5, N, 6]
    
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Solution:-
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Object[]> queue=new LinkedList<>();
        queue.offer(new Object[]{root,0});
        while(!queue.isEmpty()){
            Object[] entry=queue.poll();
            Node node=(Node)entry[0];
            int col=(int)entry[1];
            map.put(col,node.data);
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

Time Complexity: O(n log n), where n is the number of nodes in the tree. This is because we are using a TreeMap to store the nodes based on their horizontal distance, and inserting into a TreeMap takes O(log n) time. In the worst case, we may have to insert all nodes into the TreeMap, resulting in O(n log n) time complexity.
Space Complexity: O(n), where n is the number of nodes in the tree. This is because in the worst case, we may have to store all the nodes in the queue and the TreeMap.