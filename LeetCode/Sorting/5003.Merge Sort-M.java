https://www.geeksforgeeks.org/problems/merge-sort/1

5003.Merge Sort
Difficulty: MediumAccuracy: 54.1%Submissions: 275K+Points: 4Average Time: 15m
Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: We get the sorted array after using merge sort
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: We get the sorted array after using merge sort 
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

Solution:

class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    
    void merge(int[] arr,int l,int mid,int r){
        int n1=mid-l+1;
        int n2=r-mid;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[mid+i+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(R[j]<=L[i]){
                arr[k++]=R[j];
                j++;
            } else{
                arr[k++]=L[i];
                i++;
            }
        }
        
        while(i<n1){
            arr[k++]=L[i];
            i++;
        }
        
        while(j<n2){
            arr[k++]=R[j];
            j++;
        }
    }
}

Time Complexity: O(n log n) where n is the number of elements in the array. The merge sort algorithm divides the array into halves log n times and each merge operation takes O(n) time.
Space Complexity: O(n) for the temporary arrays used during the merge process. The space complexity can be considered O(1) if we ignore the space used for the temporary arrays, as the merge sort algorithm can be implemented in-place, but the standard implementation typically uses O(n) space.

Using Gap Method:

class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        gap(arr,l,r);
    }
    
    void gap(int[] arr,int l,int r){
        int gap=r-l+1;
        int n=r-l+1;
        while(gap>0){
            gap=gap/2+gap%2;
            int left=l;
            int right=l+gap;
            while(right<=r){
                if(arr[right]<arr[left]){
                    swap(left,right,arr);
                }
                left++;
                right++;
            }
            if(gap<=1) break;
        }
    }
    
    void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

Time Complexity: O(n log n) where n is the number of elements in the array. The gap method also divides the array into halves log n times and each pass through the array takes O(n) time.
Space Complexity: O(1) as we are using only a constant amount of extra space for the gap method and the swap function. The merge sort algorithm is implemented in-place using the gap method, so we do not require additional space for temporary arrays.
