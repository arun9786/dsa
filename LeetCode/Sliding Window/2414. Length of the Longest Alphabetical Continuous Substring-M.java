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

Explanation:
1. We initialize two pointers, left and right. The left pointer marks the start of the current continuous substring, and the right pointer iterates through the string.
2. We also maintain a variable maxLen to keep track of the maximum length of continuous substrings found so far.
3. As we iterate through the string with the right pointer, we check if the current character and the previous character are consecutive in the alphabet by comparing their ASCII values.
4. If they are consecutive, we update maxLen with the length of the current substring (right - left + 1).
5. If they are not consecutive, we move the left pointer to the current position of the right pointer, effectively starting a new substring.
6. Finally, we return maxLen, which contains the length of the longest alphabetical continuous substring found in the input string.

Example Walkthrough:
Consider the input string s = "abacaba".
- Initialize left = 0, maxLen = 1.
- Start iterating with right from index 1:
  - right = 1: 'b' and 'a' are consecutive, maxLen = 2.
  - right = 2: 'a' and 'b' are not consecutive, move left to 2.
  - right = 3: 'c' and 'a' are not consecutive, move left to 3.
  - right = 4: 'a' and 'c' are not consecutive, move left to 4.
  - right = 5: 'b' and 'a' are not consecutive, move left to 5. 
  - right = 6: 'a' and 'b' are not consecutive, move left to 6.

finally, maxLen = 2, which is the length of the longest continuous substring "ab".
