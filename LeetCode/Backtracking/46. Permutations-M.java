https://leetcode.com/problems/permutations/description/

46. Permutations
Solved
Medium
Topics
premium lock icon
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

Solution:-
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];
        recursion(nums,visited,ans,new ArrayList<>());
        return ans;
    }

    void recursion(int[] arr,boolean[] visited, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size()==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                temp.add(arr[i]);
                recursion(arr,visited,ans,temp);
                visited[i]=false;
                temp.removeLast();
            }
        }
    }
}

Time Complexity: O(N*N!) where N is the number of elements in the input array. This is because there are N! permutations and generating each permutation takes O(N) time.
Space Complexity: O(N) for the recursion stack and O(N) for the temporary list used to store the current permutation, resulting in O(N) overall. The space required to store the final answer is not considered in this analysis.

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(0,nums,ans);
        return ans;
    }

    void recursion(int ind,int[] arr, List<List<Integer>> ans){
        if(ind==arr.length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            ans.add(temp);
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            recursion(ind+1,arr,ans);
            swap(i,ind,arr);
        }
    }

    void swap(int i,int j, int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

Time Complexity: O(N*N!) where N is the number of elements in the input array. This is because there are N! permutations and generating each permutation takes O(N) time.
Space Complexity: O(N) for the recursion stack and O(N) for the temporary list used to store the current permutation, resulting in O(N) overall. The space required to store the final answer is not considered in this analysis.