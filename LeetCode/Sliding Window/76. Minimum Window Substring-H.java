https://leetcode.com/problems/minimum-window-substring/description/

76. Minimum Window Substring
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?

Solution:
import java.util.HashMap;
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        int l=0;
        int startIndex=0;
        int minLen=Integer.MAX_VALUE;
        int fulfilled=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch)<0){
                    fulfilled++;
                }
                map.put(ch,map.get(ch)+1);
            }
            while(fulfilled==t.length()){
                if(minLen>(r-l+1)){
                    minLen=r-l+1;
                    startIndex=l;
                }
                char lch=s.charAt(l);
                if(map.containsKey(lch)){
                    if(map.get(lch)==0){
                        fulfilled--;
                    }
                    map.put(lch,map.get(lch)-1);
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLen);
    }
}
Time Complexity: O(N) where N is the length of string s.
Space Complexity: O(M) where M is the number of unique characters in string t.