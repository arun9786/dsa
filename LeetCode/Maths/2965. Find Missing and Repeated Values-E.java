https://leetcode.com/problems/find-missing-and-repeated-values/description/

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sumArr=0;
        long prodArr=0;
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sumArr+=grid[i][j];
                prodArr+=grid[i][j]*grid[i][j];
            }
        }
        int ns=n*n;
        long orgSum=(long)ns*(ns+1)/2;
        long orgProd=(long)ns*(ns+1)*(2*ns+1)/6;

        long xmy=sumArr-orgSum;
        long x2my2=prodArr-orgProd;
        long xpy=x2my2/xmy;
        int x=(int)(xmy+xpy)/2;
        int y=(int)(xpy-x);

        return new int[]{x,y};

    }
}
Time Complexity: O(n^2) where n is the number of rows (or columns) in the grid. We traverse the entire grid once to calculate the sum and product of the elements.
Space Complexity: O(1) as we are using only a constant amount of extra space to store the sums, products, and the final results.

Explanation:
1. We initialize two variables `sumArr` and `prodArr` to store the sum and the sum of squares of the elements in the grid, respectively.
2. We iterate through the grid and calculate the sum and the sum of squares of all the elements.
3. We calculate the expected sum (`orgSum`) and the expected sum of squares (`orgProd`) for the numbers from 1 to n^2 using the formulas for the sum of the first n natural numbers and the sum of squares of the first n natural numbers.
4. We calculate the difference between the actual sum and the expected sum (`xmy`), which gives us the difference between the repeated number (x) and the missing number (y).
5. We calculate the difference between the actual sum of squares and the expected sum of squares (`x2my2`),which gives us the difference between the squares of the repeated number and the missing number.
6. We can derive the sum of the repeated and missing numbers (`xpy`) by dividing `x2my2` by `xmy`.
7. Finally, we can solve for the repeated number (x) and the missing number (y) using the equations:
   - x - y = xmy
   - x + y = xpy
   By adding these two equations, we can find x, and by substituting x back into one of the equations, we can find y.
8. We return the repeated number and the missing number as an array.

Example:
Input: grid = [[1, 2], [2, 4]]
- sumArr = 1 + 2 + 2 + 4 = 9
- prodArr = 1^2 + 2^2 + 2^2 + 4^2 = 1 + 4 + 4 + 16 = 25
- n = 2, ns = 4
- orgSum = 4 * 5 / 2 = 10
- orgProd = 4 * 5 * 9 / 6 = 30
- xmy = sumArr - orgSum = 9 - 10 = -1
- x2my2 = prodArr - orgProd = 25 - 30 = -5
- xpy = x2my2 / xmy = -5 / -1 = 5
- x = (xmy + xpy) / 2 = (-1 + 5) / 2 = 2
- y = (xpy - x) = 5 - 2 = 3
Output: [2, 3]