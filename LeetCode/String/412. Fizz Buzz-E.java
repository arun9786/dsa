https://leetcode.com/problems/fizz-buzz/submissions/1892039570/

412. Fizz Buzz
Solved
Easy
Topics
premium lock icon
Companies
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 

Constraints:

1 <= n <= 104

Solution:
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
Time Complexity: O(n) for iterating through numbers from 1 to n.
Space Complexity: O(1) if we dont count the output list, otherwise O(n)

Explanation:
1. We initialize an empty list result to store the output strings.
2. We loop through each integer i from 1 to n.
3. For each i, we check the divisibility conditions:
   - If i is divisible by both 3 and 5, we add "FizzBuzz" to the result list.
   - If i is only divisible by 3, we add "Fizz".
   - If i is only divisible by 5, we add "Buzz".
   - If none of the above, we add the string representation of i.
4. Finally, we return the result list containing the FizzBuzz strings.

Example Walkthrough:
For n = 5:
- i = 1: not divisible by 3 or 5, add "1"
- i = 2: not divisible by 3 or 5, add "2"
- i = 3: divisible by 3, add "Fizz"
- i = 4: not divisible by 3 or 5, add "4"
- i = 5: divisible by 5, add "Buzz"
The final output list will be ["1", "2", "Fizz", "4", "Buzz"].