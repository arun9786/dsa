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