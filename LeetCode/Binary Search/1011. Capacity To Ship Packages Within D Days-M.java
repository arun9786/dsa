https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

1011. Capacity To Ship Packages Within D Days
Solved
Medium
Topics
premium lock icon
Companies
Hint
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 

Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500

Solution:
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();

        while(low<high){
            int mid=(low+high)/2;
            if(isPossible(mid,days,weights)){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean isPossible(int capacity, int days, int[] weights){
        int daysCount=1;
        int sum=0;
        for(int weight:weights){
            if(sum+weight>capacity){
                daysCount++;
                sum=0;
            }
            sum+=weight;
        }
        return daysCount<=days;
    }
}

Time Complexity: O(n log m) where n is the number of packages and m is the sum of all weights. The binary search runs in O(log m) time, and for each candidate capacity, we check if it's possible to ship all packages within the given days, which takes O(n) time.
Space Complexity: O(1) since we are using only a constant amount of extra space for the low, high, mid, and daysCount variables. The input array does not require additional space as we are not modifying it.