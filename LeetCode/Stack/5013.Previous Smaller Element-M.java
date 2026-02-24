https://www.geeksforgeeks.org/problems/previous-smaller-element/1

5013.Previous Smaller Element
Previous Smaller Element
Difficulty: MediumAccuracy: 66.06%Submissions: 8K+Points: 4
You are given an integer array arr[ ]. For every element in the array, your task is to determine its Previous Smaller Element (PSE).

The Previous Smaller Element (PSE) of an element x is the first element that appears to the left of x in the array and is strictly smaller than x.

Note: If no such element exists, assign -1 as the PSE for that position.

Examples:

Input: arr[] = [1, 6, 2]
Output: [-1, 1, 1]
Explanation:
For 1, there is no element on the left, so answer is -1.
For 6, previous smaller element is 1.
For 2, previous smaller element is 1.
Input: arr[] = [1, 5, 0, 3, 4, 5]
Output: [-1, 1, -1, 0, 3, 4]
Explanation:
For 1, no element on the left, so answer is -1.
For 5, previous smaller element is 1.
For 0, no element on the left smaller than 0, so answer is -1.
For 3, previous smaller element is 0.
For 4, previous smaller element is 3.
For 5, previous smaller element is 4.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

Solution:
class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Stack<Integer> stk=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans.add(-1);
            } else{
                ans.add(stk.peek());
            }
            stk.push(arr[i]);
        }
        return ans;
    }
}

Time Complexity: O(N) where N is the length of the input array. Each element is pushed and popped at most once.
Space Complexity: O(N) in the worst case when the stack contains all elements of the array.