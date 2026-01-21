https://leetcode.com/problems/container-with-most-water/description/

11. Container With Most Water
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

Solution:
class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while(left<right){
            int currentArea=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,currentArea);
            if(height[left]<height[right]){
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}
Time Complexity: O(n) for traversing the array with two pointers.
Space Complexity: O(1) as we are using only constant extra space.

Explanation:
1. We initialize two pointers, left at the start and right at the end of the array.
2. We calculate the area formed between the lines at these two pointers and update the maximum area found so far.
3. We then move the pointer pointing to the shorter line inward, as moving the longer line inward cannot increase the area.
4. We repeat this process until the two pointers meet

Explanation with example::
Consider the input height = [1,8,6,2,5,4,8,3,7]
- Initialize left = 0, right = 8 (last index), maxArea = 0
- Calculate area: min(1, 7) * (8 - 0) = 1 * 8 = 8, maxArea = 8
- Move left pointer to 1 (since height[0] < height[8])
- Calculate area: min(8, 7) * (8 - 1) = 7 * 7 = 49, maxArea = 49
- Move right pointer to 7 (since height[1] > height[8])
- Calculate area: min(8, 3) * (7 - 1) = 3 * 6 = 18, maxArea = 49
- Move right pointer to 6 (since height[1] > height[7])
- Calculate area: min(8, 8) * (6 - 1) = 8 * 5 = 40, maxArea = 49
- Move right pointer to 5 (since height[1] > height[6])
- Calculate area: min(8, 4) * (5 - 1) = 4 * 4 = 16, maxArea = 49
- Move right pointer to 4 (since height[1] > height[5])
- Calculate area: min(8, 5) * (4 - 1) = 5 * 3 = 15, maxArea = 49
- Move right pointer to 3 (since height[1] > height[4])
- Calculate area: min(8, 2) * (3 - 1) = 2 * 2 = 4, maxArea = 49
- Move right pointer to 2 (since height[1] > height[3])
- Calculate area: min(8, 6) * (2 - 1) = 6 * 1 = 6, maxArea = 49
- Move right pointer to 1 (since height[1] > height[2])
- Now left == right, we stop..
5. Finally, we return the maximum area found.