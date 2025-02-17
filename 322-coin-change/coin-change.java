class Solution {
    // public int solve(int[] coins, int amount, int idx)
    // {
    //     if(idx == 0)
    //     {
    //         if(amount%coins[idx] == 0)
    //             return amount/coins[idx];
    //         else 
    //             return (int)1e8;
    //     }

    //     int nottake = 0 + solve(coins,amount,idx-1);
    //     int take = (int)1e8;
    //     if(coins[idx] <= amount)
    //     {
    //         take = 1 + solve(coins,amount - coins[idx],idx);
    //     }
    //     return Math.min(nottake,take);
    // }

    // public int solve(int[] coins, int amount, int idx,int dp[][])
    // {
    //     if(idx == 0)
    //     {
    //         if(amount%coins[idx] == 0)
    //             return amount/coins[idx];
    //         else 
    //             return (int)1e8;
    //     }
    //     if(dp[idx][amount] != -1)
    //     {
    //         return dp[idx][amount];
    //     }
    //     int nottake = 0 + solve(coins,amount,idx-1,dp);
    //     int take = (int)1e8;
    //     if(coins[idx] <= amount)
    //     {
    //         take = 1 + solve(coins,amount - coins[idx],idx,dp);
    //     }
    //     return dp[idx][amount] = Math.min(nottake,take);
    // }
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        // int ans  = solve(coins,amount,len - 1);
        // if(ans >= (int)1e8)
        //     return -1;
        // else
        //     return ans;
        int dp[][] = new int[len][amount+1];
        // for(int[] arr: dp)
        //     Arrays.fill(arr, -1);
        // int ans  = solve(coins,amount,len - 1,dp);
        // if(ans >= (int)1e8)
        //     return -1;
        // else
        //     return ans;
        for(int j = 0; j <= amount; j++)
        {
            if(j%coins[0] == 0)
                dp[0][j] = j/coins[0];
            else 
                dp[0][j] = (int)1e8;
        }

        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                int nottake = 0 + dp[i-1][j];
                int take = (int)1e8;
                if(coins[i] <= j)
                {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(nottake,take);
            }
        }

        return dp[len-1][amount] == (int)1e8 ? -1: dp[len-1][amount] ;
    }
}