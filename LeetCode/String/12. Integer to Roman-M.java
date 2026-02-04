https://leetcode.com/problems/integer-to-roman/description/

12. Integer to Roman
Solved
Medium
Topics
premium lock icon
Companies
Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.

 

Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
 8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
 900 = CM
  90 = XC
   4 = IV
 

Constraints:

1 <= num <= 3999

Solution:
class Solution {
    public String intToRoman(int num) {
        int value[]=new int[]{
            1000,900,500,400,100,90,50,40,10,9,5,4,1
        };
        String symbol[]=new String[]{
            "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
        };
        StringBuilder sb=new StringBuilder("");
        int i=0;
        while(num>0 && i<value.length){
            if(num<value[i]){
                i++;
                continue;
            }                
            sb.append(symbol[i]);
            num-=value[i];
        }

        return sb.toString();
    }
}

Time Complexity: O(1) since the number of Roman numeral symbols is fixed.
Space Complexity: O(1) since the output string length is bounded by a constant (the maximum number is 3999).

Explanation:
1. We create two arrays: one for the integer values of the Roman numeral symbols and another for the corresponding symbols.
2. We iterate through the value array, and for each value, we check if the input number is greater than or equal to that value.
3. If it is, we append the corresponding symbol to the result string and subtract the value from the input number.
4. We continue this process until the input number is reduced to zero.
5. Finally, we return the constructed Roman numeral string.

Example Walkthrough:
Consider the input number: 1994
- Start with num = 1994, i = 0
- 1994 >= 1000: append "M", num = 994
- 994 >= 900: append "CM", num = 94
- 94 >= 90: append "XC", num = 4
- 4 >= 4: append "IV", num = 0
- The final result is "MCMXCIV".