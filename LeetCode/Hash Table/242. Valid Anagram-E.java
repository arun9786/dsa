https://leetcode.com/problems/valid-anagram/description/

242. Valid Anagram
Solved
Easy
Topics
premium lock icon
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Solution:

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[(int)s.charAt(i)-97]++;
            freq[(int)t.charAt(i)-97]--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
} 

Time Complexity: O(N) where N is the length of the strings.
Space Complexity: O(1) as the frequency array size is constant (26).
 