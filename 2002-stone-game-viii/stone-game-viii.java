// class Solution {

//     public int solve(int idx, int[] prefix)
//     {
//         int len = prefix.length;
//         if(idx == len - 1)
//             return prefix[len - 1];

//         int take = prefix[idx] - solve(idx + 1, prefix);
//         int skip = solve(idx + 1, prefix);

//         return Math.max(take, skip);
//     }

//     public int stoneGameVIII(int[] stones) {
//         int len = stones.length;
//         int[] prefix = new int[len];

//         prefix[0] = stones[0];
//         for(int i = 1; i < len; i++)
//             prefix[i] = prefix[i - 1] + stones[i];

//         return solve(1, prefix);
//     }
// }

// class Solution {

//     public int solve(int idx, int[] prefix, int[] dp)
//     {
//         int len = prefix.length;
//         if(idx == len - 1)
//             return prefix[len - 1];

//         if(dp[idx] != -1)
//             return dp[idx];

//         int take = prefix[idx] - solve(idx + 1, prefix, dp);
//         int skip = solve(idx + 1, prefix, dp);

//         return dp[idx] = Math.max(take, skip);
//     }

//     public int stoneGameVIII(int[] stones) {
//         int len = stones.length;
//         int[] prefix = new int[len];

//         prefix[0] = stones[0];
//         for(int i = 1; i < len; i++)
//             prefix[i] = prefix[i - 1] + stones[i];

//         int[] dp = new int[len];
//         Arrays.fill(dp, -1);

//         return solve(1, prefix, dp);
//     }
// }

class Solution {

    public int stoneGameVIII(int[] stones) {
        int len = stones.length;
        int[] prefix = new int[len];

        prefix[0] = stones[0];
        for(int i = 1; i < len; i++)
            prefix[i] = prefix[i - 1] + stones[i];

        int[] dp = new int[len + 1];
        dp[len - 1] = prefix[len - 1];

        for(int i = len - 2; i >= 1; i--)
        {
            int take = prefix[i] - dp[i + 1];
            int skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }

        return dp[1];
    }
}