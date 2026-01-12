https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Solution:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        int maxLen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                left=Math.max(map.get(ch)+1,left);
            } 
            map.put(ch,right);
            int len=right-left+1;
            maxLen=Math.max(len,maxLen);
        }
        return maxLen;
    }
}

Still Better Solution:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr=new int[127];
        Arrays.fill(arr,-1);
        int left=0;
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(arr[(int)ch]!=-1){
                left=Math.max(left, arr[(int)ch]+1);
            }
            arr[(int)ch]=right;
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}

Time Complexity: O(N) for traversing the string once.
Space Complexity: O(min(N,M)) where N is the length of the string and M is the size of the character set.
           