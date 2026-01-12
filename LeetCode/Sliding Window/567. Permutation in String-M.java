https://leetcode.com/problems/permutation-in-string/description/

567. Permutation in String
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1s permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

Solution:
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1l=s1.length();
        int s2l=s2.length();
        if(s1l>s2l) return false;
        int mcount[]=new int[26];
        for(char ch:s1.toCharArray()){
            mcount[ch-'a']++;
        }
        int[] window=new int[26];
        for(int i=0;i<s2l;i++){
            if(i>=s1l){
                window[s2.charAt(i-s1l)-'a']--;
            }
            window[s2.charAt(i)-'a']++; 
            if(Arrays.equals(mcount,window)) return true;
        }
        return false;
    }
}

Time Complexity: O(N*26) where N is the length of s2.
Space Complexity: O(1) as we are using fixed size arrays of length 26.