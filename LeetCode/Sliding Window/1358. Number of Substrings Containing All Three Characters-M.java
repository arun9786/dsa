https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

1358. Number of Substrings Containing All Three Characters
Medium
Topics
premium lock icon
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

Solution:
My solution:-
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        long noOfPossibleSubArrays= (long)n*(n+1)/2;
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        //no of subarary with <=2
        long count=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                char lch=s.charAt(l);
                map.put(lch,map.get(lch)-1);
                if(map.get(lch)==0){
                    map.remove(lch);
                }
                l++;
            }
            count+=(r-l+1);
        }
        return (int)(noOfPossibleSubArrays-count);
    }
}

Optimized solution:-
class Solution {
    public int numberOfSubstrings(String s) {
        int max=0,left=0,maxLen=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char val=s.charAt(right);
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()==3){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen+=left;
        }
        return maxLen;
    }
}

Time Complexity: O(N) where N is the number of characters in the string.
Space Complexity: O(1) since the map will at most contain 3 characters.