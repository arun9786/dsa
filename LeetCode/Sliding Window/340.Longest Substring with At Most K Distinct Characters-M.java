https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

340. Longest Substring with At Most K Distinct Characters
Attempted
Medium
Topics
premium lock icon
Companies
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" which its length is 2.

Constraints:
1 <= s.length <= 5 * 104
0 <= k <= 50

Solution:-
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max=0,left=0,maxLen=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char val=s.charAt(right);
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            if(map.size()==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}

Time Complexity: O(n) where n is the length of the string s, since we are traversing the string once.
Space Complexity: O(k) since we are storing at most k distinct characters in the map.
