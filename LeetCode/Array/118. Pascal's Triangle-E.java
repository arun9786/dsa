https://leetcode.com/problems/pascals-triangle/description/

118. Pascals Triangle
Solved
Easy
Topics
premium lock icon
Companies
Given an integer numRows, return the first numRows of Pascals triangle.

In Pascals triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

Solution:
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            long ans=1;
            List<Integer> subList=new ArrayList<>();
            subList.add(1);
            for(long col=1;col<row;col++){
                ans=ans*(row-col)/col;
                subList.add((int)ans);
            }
            result.add(subList);
        }
        return result;
    }
}

Time Complexity: O(numRows^2) for generating the triangle, as we need to calculate each element in the triangle up to numRows. The number of elements in the nth row is n, so the total number of elements up to numRows is 1 + 2 + ... + numRows = numRows * (numRows + 1) / 2, which simplifies to O(numRows^2).
Space Complexity: O(numRows^2)

Explanation:
1. We initialize an empty list of lists called `result` to store the rows of Pascal's triangle.
2. We iterate through each row from 1 to `numRows`.
3. For each row, we initialize a variable `ans` to 1, which will be used to calculate the values in the current row.
4. We create a new list called `subList` to store the values of the current row and add the first element (which is always 1) to it.
5. We then iterate through the columns of the current row, starting from 1 to the current row number. For each column, we calculate the value using the formula `ans = ans * (row - col) / col`, which is derived from the properties of Pascal's triangle.
6. We add the calculated value `ans` to the `subList`.
7. After processing all columns for the current row, we add the `subList` to the `result` list.
8. Finally, we return the `result` list, which contains the first `numRows` of Pascal's triangle.

Example:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
- For row 1: subList = [1]
- For row 2: subList = [1, 1]
- For row 3: subList = [1, 2, 1]
- For row 4: subList = [1, 3, 3, 1]
- For row 5: subList = [1, 4, 6, 4, 1]

