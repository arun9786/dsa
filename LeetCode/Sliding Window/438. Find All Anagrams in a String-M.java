https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

438. Find All Anagrams in a String
Solved
Medium
Topics
premium lock icon
Companies
Given two strings s and p, return an array of all the start indices of p anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

Solution:
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int arrs[]=new int[26];
        for(char ch:p.toCharArray()){
            arrs[(int)ch-97]++;
        }
        int arrd[]=new int[26];
        int left=0;
        List<Integer> ans=new ArrayList<>();
        for(int right=0;right<s.length();right++){
            if(right-left==p.length()){
                arrd[(int)(s.charAt(left)-97)]--;
                left++;
            }
            char ch=s.charAt(right);
            arrd[(int)ch-97]++;
            if(Arrays.equals(arrs,arrd)){
                ans.add(left);
            }
        }
        return ans;
    }
}

Time Complexity: O(N*26) where N is the length of string s.
Space Complexity: O(1) as we are using fixed size arrays of length 26.

