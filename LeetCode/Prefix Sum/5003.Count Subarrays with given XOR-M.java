https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

Count Subarrays with given XOR
Difficulty: MediumAccuracy: 58.86%Submissions: 73K+Points: 4
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤105
0 ≤ k ≤ 105

Solution:

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int prefixXor=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            prefixXor^=arr[i];
            if(map.containsKey(prefixXor^k)){
                count+=map.get(prefixXor^k);
            }
            map.put(prefixXor,map.getOrDefault(prefixXor,0)+1);
        }
        return count;
    }
}

Time Complexity: O(n) where n is the number of elements in the input array. We traverse the array once to calculate the prefix XOR and count the subarrays.
Space Complexity: O(n) in the worst case, where n is the number of elements in the input array. This is because in the worst case, all prefix XOR values could be distinct and stored in the HashMap. However, in practice, the number of distinct prefix XOR values may be less than n, so the space complexity can be considered O(min(n, m)), where m is the range of possible XOR values (which is limited by the maximum value of arr[i] and k).

Explanation:
1. We initialize a variable `prefixXor` to keep track of the cumulative XOR of the elements as we iterate through the array.
2. We also initialize a variable `count` to count the number of subarrays that have an XOR equal to k.
3. We use a HashMap `map` to store the frequency of each prefix XOR value encountered. We start by putting the prefix XOR value of 0 with a frequency of 1 in the map, which accounts for the case where a subarray itself has an XOR equal to k.
4. As we iterate through the array, we update the `prefixXor` by XORing it with the current element.
5. We then check if the XOR of the current `prefixXor` with k (i.e., `prefixXor ^ k`) exists in the map. If it does, it means there are some previous prefix XOR values that can be XORed with the current `prefixXor` to yield k, which indicates that there are subarrays ending at the current index that have an XOR of k. We add the frequency of that prefix XOR value to our count.
6. Finally, we update the frequency of the current `prefixXor` in the map by incrementing its count.
7. After iterating through the entire array, we return the total count of subarrays that have an XOR equal to k.

Example:
Input: arr[] = [4, 2, 2, 6, 4], k = 6
- Initialize `prefixXor = 0`, `count = 0`, and `map = {0: 1}`.
- i = 0:
  - `prefixXor = 0 ^ 4 = 4`
  - `prefixXor ^ k = 4 ^ 6 = 2` (not in map)
  - Update map: `map = {0: 1, 4: 1}`
- i = 1:
  - `prefixXor = 4 ^ 2 = 6`
  - `prefixXor ^ k = 6 ^ 6 = 0` (in map with frequency 1)
  - `count = count + 1 = 1`
  - Update map: `map = {0: 1, 4: 1, 6: 1}`
- i = 2:
  - `prefixXor = 6 ^ 2 = 4`
  - `prefixXor ^ k = 4 ^ 6 = 2` (not in map)
  - Update map: `map = {0: 1, 4: 2, 6: 1}`
- i = 3:
  - `prefixXor = 4 ^ 6 = 2`
  - `prefixXor ^ k = 2 ^ 6 = 4` (in map with frequency 2)
  - `count = count + 2 = 3`
  - Update map: `map = {0: 1, 4: 2, 6: 1, 2: 1}`
- i = 4:
  - `prefixXor = 2 ^ 4 = 6`
  - `prefixXor ^ k = 6 ^ 6 = 0` (in map with frequency 1)
  - `count = count + 1 = 4`
  - Update map: `map = {0: 1, 4: 2, 6: 2, 2: 1}`
- Final count = 4, which matches the expected output.