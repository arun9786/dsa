https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

1456. Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

Solution:
class Solution {
    public int maxVowels(String s, int k) {
        int left=0,maxLen=0,count=0;;
        for(int right=0;right<s.length();right++){
            if(right>=k){
                char ch=s.charAt(left);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    count--;
                }
                left++;
            }
            char ch=s.charAt(right);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
                maxLen=Math.max(maxLen,count);
            }
        } 
        return maxLen;
    }
}

Time Complexity: O(N) where N is the length of the string s.
Space Complexity: O(1) as we are using only constant extra space.