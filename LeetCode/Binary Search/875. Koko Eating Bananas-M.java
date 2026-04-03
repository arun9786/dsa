https://leetcode.com/problems/koko-eating-bananas/description/

875. Koko Eating Bananas
Solved
Medium
Topics
premium lock icon
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109

Solution:
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        while(low<high){
            int mid=low+(high-low)/2;
            int hours=0;
            for(int pile:piles){
                hours+=Math.ceil((double)pile/mid);
            }
            if(hours>h){
                low=mid+1;
            } else {
                high=mid;
            }
        }
        return low;
    }
}

Time Complexity: O(n log m) where n is the number of piles and m is the maximum number of bananas in any pile. The binary search runs in O(log m) time, and for each candidate eating speed, we calculate the total hours needed to eat all the bananas, which takes O(n) time.
Space Complexity: O(1) since we are using only a constant amount of extra space to store the low, high, mid, and hours variables. The input array does not require additional space as we are not modifying it.
        