https://leetcode.com/problems/sliding-window-median/description/

480. Sliding Window Median
Attempted
Hard
Topics
premium lock icon
Companies
Hint
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation: 
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6
Example 2:

Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 

Constraints:

1 <= k <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

Solution:
import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double[] result=new double[n-k+1];
        Queue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> right=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            left.add(nums[i]);
        }
        for(int i=0;i<k/2;i++){
            right.add(left.poll());
        }
        result[0]=getMedian(left,right,k);
        for(int i=k;i<n;i++){
            int toRemove=nums[i-k];
            if(!left.isEmpty() && toRemove<=left.peek()){
                left.remove(toRemove);
            } else {
                right.remove(toRemove);
            }
            if(!left.isEmpty() && nums[i]<=left.peek()){
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
            //rebalance
            while(left.size()>right.size()+1){
                right.add(left.poll());
            }
            while(right.size()>left.size()){
                left.add(right.poll());
            }
            result[i-k+1]=getMedian(left,right,k);
        }
        return result;
    }
    
    private double getMedian(Queue<Integer> left, Queue<Integer> right, int k){
        if(k%2==0){
            return (left.peek()/2.0 + right.peek()/2.0);
        } else {
            return left.peek();
        }
    }
}