https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/

2414. Length of the Longest Alphabetical Continuous Substring
Solved
Medium
Topics
premium lock icon
Companies
Hint
An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".

For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.

 

Example 1:

Input: s = "abacaba"
Output: 2
Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
"ab" is the longest continuous substring.
Example 2:

Input: s = "abcde"
Output: 5
Explanation: "abcde" is the longest continuous substring.
 

Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.

Solution:
class Solution {
    public int longestContinuousSubstring(String s) {
        int left=0,maxLen=1;
        for(int right=1;right<s.length();right++){
            if((int)s.charAt(right-1)==((int)s.charAt(right)-1)){
                maxLen=Math.max(maxLen,right-left+1);
            } else{
                left=right;
            }
        }
        return maxLen;
    }
}

Time Complexity: O(N) where N is the number of characters in the string.
Space Complexity: O(1) as we are using only constant extra space.