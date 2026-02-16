https://leetcode.com/problems/pascals-triangle-ii/description/

119. Pascal's Triangle II
Solved
Easy
Topics
premium lock icon
Companies
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

Solution:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        long ans=1;
        result.add(1);
        for(long col=1;col<=rowIndex;col++){
            ans=ans*(rowIndex-col+1)/col;
            result.add((int)ans);
        }
        return result;
    }
}

Time Complexity: O(rowIndex) for generating the row, as we need to calculate each element in the row up to rowIndex. The number of elements in the row is rowIndex + 1, so the total number of elements is O(rowIndex).
Space Complexity: O(rowIndex) for storing the result list, which contains rowIndex + 1 elements.

Explanation:
1. We initialize an empty list called `result` to store the values of the requested row of Pascal's triangle.
2. We initialize a variable `ans` to 1, which will be used to calculate the values in the current row.
3. We add the first element (which is always 1) to the `result` list.
4. We then iterate through the columns of the current row, starting from 1 to `rowIndex`. For each column, we calculate the value using the formula `ans = ans * (rowIndex - col + 1) / col`, which is derived from the properties of Pascal's triangle.
5. We add the calculated value `ans` to the `result` list.
6. After processing all columns for the current row, we return the `result` list, which contains the values of the requested row of Pascal's triangle.

Example:
Input: rowIndex = 3
Output: [1,3,3,1]
- For rowIndex 3: result = [1, 3, 3, 1] after processing columns 1 to 3.