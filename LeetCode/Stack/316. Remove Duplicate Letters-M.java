https://leetcode.com/problems/remove-duplicate-letters/description/?envType=problem-list-v2&envId=monotonic-stack

316. Remove Duplicate Letters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

Solution:-
class Solution {
    public String removeDuplicateLetters(String s) {
        int lastPosArr[]=new int[26];
        for(int i=0;i<s.length();i++){
            lastPosArr[s.charAt(i)-'a']=i;
        }
        boolean[] visited=new boolean[26];
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(visited[ch-'a']) continue;
            while(!stk.isEmpty() && stk.peek()>ch && lastPosArr[stk.peek()-'a']>i){
                char removed=stk.pop();
                visited[removed-'a']=false;
            }
            stk.push(ch);
            visited[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:stk){
            sb.append(ch);
        }
        return sb.toString();
    }
}
Time Complexity: O(n) where n is the length of the input string s. We traverse the string once to fill the lastPosArr and then we traverse it again to build the result using a stack. Each character is pushed and popped from the stack at most once, resulting in O(n) time complexity.
Space Complexity: O(1) since the size of the lastPosArr and visited arrays is fixed at 26 (the number of lowercase English letters), and the stack can hold at most 26 characters as well. Therefore, the additional space used does not grow with the input size, resulting in O(1) space complexity.