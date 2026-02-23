https://leetcode.com/problems/valid-parentheses/description/

20. Valid Parentheses
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Solution:
1. using Stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            } else{
                if(stk.isEmpty()) return false;
                char top=stk.pop();
                if(!((ch==')' && top=='(') || (ch=='}' && top=='{') || (ch==']' && top=='['))){
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}
Time Complexity: O(n) where n is the length of the input string s, since we need to iterate through each character in the string once.
Space Complexity: O(n) in the worst case, if all characters in the string are opening brackets, we will push all of them onto the stack. In the best case, if the string is empty or contains only valid pairs of brackets, the space complexity would be O(1).