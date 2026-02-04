https://leetcode.com/problems/palindromic-substrings/description/

647. Palindromic Substrings
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.

Solution:
class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=palindrome(s,i,i);
            res+=palindrome(s,i,i+1);
        }
        return res;
    }

    public int palindrome(String s, int left,int right){ 
        int count=0;
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}

Time Complexity: O(n^2) where n is the length of the string. We are expanding around each character and checking for palindromes.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We iterate through each character in the string and consider it as the center of a palindrome.
2. We call the helper function palindrome twice for each character: once for odd-length palindromes (single center) and once for even-length palindromes (two centers).
3. The palindrome function expands around the given left and right indices and counts the number of palindromic substrings by checking if the characters at the left and right indices are equal.
4. We keep expanding until the characters at the left and right indices are not equal or we go out of bounds.
5. Finally, we return the total count of palindromic substrings.

Example:
Consider the string s = "cadfdasf".
- For i = 0 (center 'c'):
  - Odd-length: "c" -> count = 1
  - Even-length: No palindrome -> count = 0
- For i = 1 (center 'a'):
  - Odd-length: "a" -> count = 1
  - Even-length: No palindrome -> count = 0
- For i = 2 (center 'd'):
  - Odd-length: "d", "dfd" -> count = 2
  - Even-length: No palindrome -> count = 0
- Continue this process for all characters in the string.
The total count of palindromic substrings in "cadfdasf" is 10.