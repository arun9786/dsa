https://leetcode.com/problems/longest-repeating-character-replacement/description/

424. Longest Repeating Character Replacement
Solved
Medium
Topics
premium lock icon
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

Solution:

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0;
        int maxFreq=0;
        int maxLen=0;
        int[] map=new int[26];
        for(int r=0;r<n;r++){
            int ch=s.charAt(r)-'A';
            map[ch]++;
            maxFreq=Math.max(maxFreq,map[ch]);
            int windowLen=r-l+1;
            while(windowLen-maxFreq>k){
                int lch=s.charAt(l)-'A';
                map[lch]--;
                for(int i=0;i<26;i++){
                    maxFreq=Math.max(maxFreq,map[i]);
                }
                l++;
                windowLen=r-l+1;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}

Time Complexity: O(N*26) for traversing the string once and calculating maxFreq in each iteration.
Space Complexity: O(1) as the array size is fixed to 26.

Optimal:-
class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0;
        int maxFreq=0;
        int maxLen=0;
        int[] map=new int[26];
        for(int r=0;r<n;r++){
            int ch=s.charAt(r)-'A';
            map[ch]++;
            maxFreq=Math.max(maxFreq,map[ch]);
            int windowLen=r-l+1;
            while(windowLen-maxFreq>k){
                int lch=s.charAt(l)-'A';
                map[lch]--;
                maxFreq=Math.max(maxFreq,map[lch]);
                l++;
                windowLen=r-l+1;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}

Time Complexity: O(N) for traversing the string once.
Space Complexity: O(1) as the array size is fixed to 26.