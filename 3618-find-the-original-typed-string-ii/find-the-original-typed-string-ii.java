// class Solution {

//     public int notPossibleString(int i, int size, int[] freq, int k)
//     {
//         if(i > 25)
//             return 0;
        
//         if(size > k)
//             return 0;
        
//         int result = 0;
        
//         for(int j = 1; j <= freq[i]; j++)
//         {
//             if(size + j < k)
//             {
//                 result += notPossibleString(i + 1, size + j, freq, k);
//             }
//         }

//         return result;
//     }   

//     public int possibleStringCount(String word, int k) {
//         int[] freq = new int[26];
//         int total = 1;
//         int wrongStringCount = 0;

//         for(char ch : word.toCharArray())
//         {
//             freq[ch - 'a']++;
//         }

//         for(int i = 0; i < 26; i++)
//         {
//             if(freq[i] != 0)
//                 total *= freq[i];
//         }

//         wrongStringCount = notPossibleString(0, 0, freq, k);

//         return total - wrongStringCount;        
//     }
// }


class Solution {
    int MOD = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (k > word.length()) return 0;

        List<Integer> groupFrequencies = new ArrayList<>();
        int currentGroupSize = 1;

        // Group consecutive same characters and record their frequencies
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                currentGroupSize++;
            } else {
                groupFrequencies.add(currentGroupSize);
                currentGroupSize = 1;
            }
        }
        groupFrequencies.add(currentGroupSize);

        long totalWays = 1;
        for (int freq : groupFrequencies) {
            totalWays = (totalWays * freq) % MOD;
        }

        if (groupFrequencies.size() >= k) return (int) totalWays;

        int numGroups = groupFrequencies.size();
        int[][] dp = new int[numGroups + 1][k + 1];

        // Base case: only 1 way to place remaining groups into fewer than k parts
        for (int groupsUsed = k - 1; groupsUsed >= 0; groupsUsed--) {
            dp[numGroups][groupsUsed] = 1;
        }

        for (int groupIndex = numGroups - 1; groupIndex >= 0; groupIndex--) {
            int[] prefixSums = new int[k + 2];
            for (int usedGroups = 1; usedGroups <= k; usedGroups++) {
                prefixSums[usedGroups] = (prefixSums[usedGroups - 1] + dp[groupIndex + 1][usedGroups - 1]) % MOD;
            }

            for (int groupsUsed = k - 1; groupsUsed >= 0; groupsUsed--) {
                int left = groupsUsed + 1;
                int right = groupsUsed + groupFrequencies.get(groupIndex);

                if (right + 1 > k) right = k - 1;

                if (left <= right) {
                    dp[groupIndex][groupsUsed] = (prefixSums[right + 1] - prefixSums[left] + MOD) % MOD;
                }
            }
        }

        long invalidWays = dp[0][0];
        return (int)((totalWays - invalidWays + MOD) % MOD);
    }
}
