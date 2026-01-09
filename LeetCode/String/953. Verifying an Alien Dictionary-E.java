https://leetcode.com/problems/verifying-an-alien-dictionary/description/

953. Verifying an Alien Dictionary
Solved
Easy
Topics
premium lock icon
Companies
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.

Solution:-

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            map.put(ch,i);
        }
        for(int i=0;i<words.length-1;i++){
            String left=words[i];
            String right=words[i+1];
            int ln=left.length(),rn=right.length();
            boolean matchFound=false;
            for(int j=0;j<Math.min(ln,rn);j++){
                char lc=left.charAt(j);
                char rc=right.charAt(j);
                if(lc!=rc){
                    matchFound=false;
                    if(map.get(lc)>map.get(rc)){
                        return false;
                    } else{
                        break;
                    }
                } else{
                    matchFound=true;
                }
            }
            if(matchFound && ln>rn){
                return false;
            }
        }
        return true;
    }
}

Time Complexity: O(N*M) where N is the number of words and M is the average length of the words.
Space Complexity: O(1) since the map will always have 26 characters.