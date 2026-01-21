https://leetcode.com/problems/trapping-rain-water/description/

42. Trapping Rain Water
Solved
Hard
Topics
premium lock icon
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Solution:
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lmax=0,rmax=0,left=0,right=n-1;
        int waterCount=0;
        while(left<right){
            if(height[left]<height[right]){
                lmax=Math.max(lmax,height[left]);
                waterCount+=lmax-height[left];
                left++;
            } else{
                rmax=Math.max(rmax,height[right]);
                waterCount+=rmax-height[right];
                right--;
            }
        }
        return waterCount;
    }
}
Time Complexity: O(n) for traversing the array with two pointers.
Space Complexity: O(1) as we are using only constant extra space.


class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lmaxarr[]=new int[n];
        int rmaxarr[]=new int[n];
        int lmax=0,rmax=0;
        for(int i=0;i<n;i++){
            lmax=Math.max(lmax,height[i]);
            lmaxarr[i]=lmax;
        }
        for(int i=n-1;i>=0;i--){
            rmax=Math.max(rmax,height[i]);
            rmaxarr[i]=rmax;
        }
        int waterCount=0;
        for(int i=0;i<n;i++){
            waterCount+=Math.min(lmaxarr[i],rmaxarr[i])-height[i];
        }
        return waterCount;
    }
}

Time Complexity: O(n) for traversing the array multiple times.
Space Complexity: O(n) for storing the left max and right max arrays.

Explanation:
1. We use two pointers, left and right, starting from the beginning and end of the array respectively.
2. We maintain two variables, lmax and rmax, to keep track of the maximum height encountered from the left and right sides.
3. We iterate until the left pointer is less than the right pointer.
4. At each step, we compare the heights at the left and right pointers.
5. If the height at the left pointer is less than that at the right pointer, we update lmax and calculate the water that can be trapped at the left pointer.
6. We then move the left pointer to the right.
7. If the height at the right pointer is less than or equal to that at the left pointer, we update rmax and calculate the water that can be trapped at the right pointer.
8. We then move the right pointer to the left.
9. Finally, we return the total water trapped.
Explanation with example::
Consider the input height = [0,1,0,2,1,0,1,3,2,1,2,1]
- Initialize left = 0, right = 11, lmax = 0, rmax = 0, waterCount = 0
- height[0] < height[11]: lmax = max(0, 0) = 0, waterCount += 0 - 0 = 0, left = 1
- height[1] < height[11]: lmax = max(0, 1) = 1, waterCount += 1 - 1 = 0, left = 2
- height[2] < height[11]: lmax = max(1, 0) = 1, waterCount += 1 - 0 = 1, left = 3
- height[3] < height[11]: lmax = max(1, 2) = 2, waterCount += 2 - 2 = 0, left = 4
- height[4] < height[11]: lmax = max(2, 1) = 2, waterCount += 2 - 1 = 1, left = 5
- height[5] < height[11]: lmax = max(2, 0) = 2, waterCount += 2 - 0 = 2, left = 6
- height[6] < height[11]: lmax = max(2, 1) = 2, waterCount += 2 - 1 = 1, left = 7
- height[7] >= height[11]: rmax = max(0, 1) = 1, waterCount += 1 - 1 = 0, right = 10
- height[7] >= height[10]: rmax = max(1, 2) = 2, waterCount += 2 - 2 = 0, right = 9
- height[7] >= height[9]: rmax = max(2, 1) = 2, waterCount += 2 - 1 = 1, right = 8
- height[7] >= height[8]: rmax = max(2, 2) = 2, waterCount += 2 - 2 = 0, right = 7
- Now left == right, we stop.
- The total water trapped is 6, so we return 6.