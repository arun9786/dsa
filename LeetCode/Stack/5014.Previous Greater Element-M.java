https://www.geeksforgeeks.org/problems/previous-greater-element/1

5014.Previous Greater Element

Previous Greater Element
Difficulty: MediumAccuracy: 72.09%Submissions: 6K+Points: 4
You are given an integer array arr[ ]. For every element in the array, your task is to determine its Previous Greater Element (PGE).

The Previous Greater Element (PGE) of an element x is the first element that appears to the left of x in the array and is strictly greater than x.


Note: If no such element exists, assign -1 as the PGE for that position.

Examples:

Input: arr[] = [10, 4, 2, 20, 40, 12, 30]
Output: [-1, 10, 4, -1, -1, 40, 40]
Explanation:
For 10, no elements on the left, so answer is -1.
For 4, previous greater element is 10.
For 2, previous greater element is 4.
For 20, no element on the left greater than 20, so answer is -1.
For 40, no element on the left greater than 40, so answer is -1.
For 12, previous greater element is 40.
For 30, previous greater element is 40.
Input: arr[] = [10, 20, 30, 40]
Output: [-1, -1, -1, -1]
Explanation: Each element of the array has no previous greater element.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

Solution:-
class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        Stack<Integer> stk=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && stk.peek()<=arr[i]){
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