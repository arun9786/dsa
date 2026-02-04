https://leetcode.com/problems/find-the-town-judge/description/

997. Find the Town Judge
Solved
Easy
Topics
premium lock icon
Companies
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n

Solution:
class Solution {
    public int findJudge(int n, int[][] trust) {
        int score[]=new int[n+1];
        for(int j=0;j<trust.length;j++){
            int follow=trust[j][0];
            int trst=trust[j][1];
            score[follow]--;
            score[trst]++;
        }
        for(int i=1;i<score.length;i++){
            if(score[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}

Time Complexity: O(T) where T is the length of the trust array.
Space Complexity: O(N) where N is the number of people in the town.

Explanation:
1. We can use an array to keep track of the trust score for each person. The score increases by 1 for every person that trusts them and decreases by 1 for every person they trust.
2. After processing the trust relationships, the town judge will be the person with a score of n-1 (trusted by everyone else and trusts no one).
3. We iterate through the score array to find the person with the score of n-1 and return their label. If no such person exists, we return -1.
4. This approach ensures we efficiently determine the town judge in a single pass through the trust array and a subsequent pass through the score array.

Example Walkthrough:
Consider n = 3 and trust = [[1,3],[2,3]]:
- Initialize score array: score = [0, 0, 0, 0]
- Process trust relationships:
  - For [1, 3]: score[1]-- -> score = [0, -1, 0, 1]
  - For [2, 3]: score[2]-- -> score = [0, -1, -1, 2]
- Check scores:
  - score[1] = -1 (not the judge)
  - score[2] = -1 (not the judge)
  - score[3] = 2 (this is n-1, so person 3 is the judge)
- Return 3 as the town judge.