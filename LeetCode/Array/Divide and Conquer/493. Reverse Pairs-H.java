https://leetcode.com/problems/reverse-pairs/description/

493. Reverse Pairs
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

Solution:-

class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }

    int mergeSort(int []arr,int low,int high){
        int count=0;
        if(low<high){
            int mid=(low+high)/2;
            count+=mergeSort(arr,low,mid);
            count+=mergeSort(arr,mid+1,high);
            count+=countPairs(arr,low,mid,high);
            merge(arr,low,mid,high);
        }
        return count;
    }

    int countPairs(int arr[],int low,int mid,int high){
        int left=low,right=mid+1;
        int count=0;
        while(left<=mid && right<=high){
            if((long)arr[left]>(long)arr[right]*2){
                count+=(mid-left+1);
                right++;
            } else{
                left++;
            }
        }
        return count;
    }


    void merge(int arr[],int low,int mid,int high){
        int n=high-low+1;
        int temp[]=new int[n];
        int left=low,right=mid+1,k=0;
        while(left<=mid && right<=high){
            if(arr[right]<arr[left]){
                temp[k++]=arr[right++];
            } else{
                temp[k++]=arr[left++];
            }
        }

        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }

        for(int i=0;i<n;i++){
            arr[low+i]=temp[i];
        }
    }
}

Time Complexity: O(nlogn) for merge sort and O(n) for counting pairs, so overall O(nlogn).
Space Complexity: O(n) for the temporary array used in merging.