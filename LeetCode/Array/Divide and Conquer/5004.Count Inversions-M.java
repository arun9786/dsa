https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

Count Inversions
Difficulty: MediumAccuracy: 16.93%Submissions: 743K+Points: 4
Given an array of integers arr[]. You have to find the Inversion Count of the array. 
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

Solution:-
class Solution {
    static int inversionCount(int arr[]) {
        int n=arr.length;
        
        return mergeSort (arr,0,n-1);
        
    }
    
    static int mergeSort(int arr[],int low, int high){
        int count=0;
        if(low<high){
            int mid=(low+high)/2;
            count+=mergeSort(arr,low,mid);
            count+=mergeSort(arr,mid+1,high);
            count+=countOfInversions(arr,low,mid,high);
            merge(arr,low,mid,high);
        }
        return count;
    }
    
    static int countOfInversions(int[] arr,int low,int mid,int high){
        int left=low,right=mid+1;
        int count=0;
        while(left<=mid && right<=high){
            if(arr[left]>arr[right]){
                count+=(mid-left+1);
                right++;
            } else{
                left++;
            }
        }
        return count;
    }
    
    static void merge(int []arr,int low,int mid,int high){
        int temp[]=new int[high-low+1];
        int left=low,right=mid+1,k=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            } else{
                temp[k++]=arr[right++];
            }
        }
        
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=0;i<high-low+1;i++){
            arr[low+i]=temp[i];
        }
    }
        
}

Time Complexity: O(nlogn) for merge sort and O(n) for counting pairs, so overall O(nlogn).
Space Complexity: O(n) for the temporary array used in merging.

