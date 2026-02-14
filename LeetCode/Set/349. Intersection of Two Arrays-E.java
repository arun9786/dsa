https://leetcode.com/problems/intersection-of-two-arrays/description/

349. Intersection of Two Arrays
Solved
Easy
Topics
premium lock icon
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Solution:-
class Solution { 
    public int[] intersection(int[] nums1, int[] nums2) 
    { 
        Set<Integer> set=new HashSet<>(); 
        for(int num:nums1){ 
            set.add(num);
        }
        Set<Integer> resultSet=new HashSet<>(); 
        for(int num:nums2)
        { 
            if(set.contains(num)){
                resultSet.add(num); 
            } 
        } 
        int[] result=new int[resultSet.size()];
        int index=0; 
        for(int num:resultSet){ 
            result[index++]=num; 
        } 
        return result; 
        } 
} 
Time Complexity: O(n + m) where n and m are the lengths of nums1 and nums2 respectively. 
Space Complexity: O(n) for storing the elements of nums1 in the set and O(k) for storing the intersection in the result set, where k is the number of unique elements in the intersection.