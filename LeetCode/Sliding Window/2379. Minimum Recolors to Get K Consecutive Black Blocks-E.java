https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

2379. Minimum Recolors to Get K Consecutive Black Blocks
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

 

Example 1:

Input: blocks = "WBBWWBBWBW", k = 7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW". 
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.
Example 2:

Input: blocks = "WBWBBBW", k = 2
Output: 0
Explanation:
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.
 

Constraints:

n == blocks.length
1 <= n <= 100
blocks[i] is either 'W' or 'B'.
1 <= k <= n

Solution:
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left=0,whiteCount=0,min=Integer.MAX_VALUE;
        for(int right=0;right<blocks.length();right++){
            if(blocks.charAt(right)=='W'){
                whiteCount++;
            }
            if(right-left+1==k){
                min=Math.min(min,whiteCount);
                if(blocks.charAt(left)=='W'){
                    whiteCount--;
                }
                left++;
            }
        }
        return min;
    }
}
Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(1) as we are using only constant extra space.