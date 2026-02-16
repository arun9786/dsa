https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

5002.Merge Without Extra Space
Difficulty: MediumAccuracy: 32.01%Submissions: 328K+Points: 4Average Time: 20m
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

Examples:

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output: a[] = [2, 2, 3, 4], b[] = [7, 10]
Explanation: After merging the two non-decreasing arrays, we get, [2, 2, 3, 4, 7, 10]
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output: a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]
Explanation: After merging two sorted arrays we get [1, 2, 3, 5, 8, 9, 10, 13, 15, 20].
Input: a[] = [0, 1], b[] = [2, 3]
Output: a[] = [0, 1], b[] = [2, 3]
Explanation: After merging two sorted arrays we get [0, 1, 2, 3].
Constraints:
1 ≤ n, m ≤ 105
0 ≤ a[i], b[i] ≤ 107

Solution:

class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n=a.length;
        int m=b.length;
        int gap=n+m;
        while(gap>0){
            gap=gap/2+gap%2;
            int left=0,right=gap;
            while(right<n+m){
                if(left<n && right<n){
                    if(a[right]<a[left]){
                        int temp=a[left];
                        a[left]=a[right];
                        a[right]=temp;
                    }
                } else if(left>=n && right>=n){
                    if(b[right-n]<b[left-n]){
                        int temp=b[left-n];
                        b[left-n]=b[right-n];
                        b[right-n]=temp;
                    }
                } else{
                    if(b[right-n]<a[left]){
                        int temp=a[left];
                        a[left]=b[right-n];
                        b[right-n]=temp;
                    }
                }
                left++;
                right++;
            }
            
            if(gap==1) break;
        }
    }
    
}


Time Complexity: O(log(n+m))*O(n+m)
Space Complexity: O(1)