https://leetcode.com/problems/valid-palindrome/description/

125. Valid Palindrome
Solved
Easy
Topics
premium lock icon
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

Solution:
class Solution {
    public boolean isPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left)) ){
                left++;
            }
            while(right>left && !Character.isLetterOrDigit(s.charAt(right)) ){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We initialize two pointers, left and right, to the start and end of the string, respectively.
2. We move the left pointer to the right until we find an alphanumeric character.
3. We move the right pointer to the left until we find an alphanumeric character.
4. We compare the characters at the left and right pointers after converting them to lowercase.
5. If they are not equal, we return false.
6. If they are equal, we move both pointers inward and repeat the process until the pointers meet or cross.
7. If we complete the process without finding any mismatches, we return true.
Explanation with example::
Consider the input s = "A man, a plan, a canal: Panama"
- Initialize left = 0, right = 29
- Move left to 0 (A) and right to 28 (a), compare 'a' and 'a' -> equal
- Move left to 1 (space) and right to 27 (m), skip space, compare 'm' and 'm' -> equal
- Move left to 3 (m) and right to 26 (a), compare 'm' and 'a' -> equal
- Continue this process until left >= right
- Since all comparisons are equal, return true