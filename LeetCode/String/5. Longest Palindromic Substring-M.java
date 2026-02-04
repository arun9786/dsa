https://leetcode.com/problems/longest-palindromic-substring/description/

5. Longest Palindromic Substring
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

Solution:
class Solution {
    public String longestPalindrome(String s) {
        int maxLen=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            int oddLen=palindrome(s,i,i);
            int evenLen=palindrome(s,i,i+1);
            int max=Math.max(oddLen,evenLen);
            if(max>maxLen){
                maxLen=max;
                start=i-(maxLen-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }

    public int palindrome(String s,int left,int right){
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left+1-2;
    }
}

Time Complexity: O(n^2) where n is the length of the string. We are expanding around each character and checking for palindromes.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We iterate through each character in the string and consider it as the center of a potential palindrome.
2. For each character, we check for both odd-length and even-length palindromes by expanding around the center.
3. We keep track of the maximum length palindrome found and its starting index.
4. Finally, we return the longest palindromic substring using the starting index and maximum length.

Example:
Input: s = "babad"
- For i = 0 ('b'): oddLen = 1, evenLen = 0, maxLen = 1, start = 0
- For i = 1 ('a'): oddLen = 3 ("bab"), evenLen = 0, maxLen = 3, start = 0
- For i = 2 ('b'): oddLen = 3 ("aba"), evenLen = 0, maxLen = 3, start = 0
- For i = 3 ('a'): oddLen = 1, evenLen = 0, maxLen = 3, start = 0
- For i = 4 ('d'): oddLen = 1, evenLen = 0, maxLen = 3, start = 0
Output: "bab" or "aba"