// class Solution {
//     static final long NEG_INF = -(long)1e18;
//     public long solve(int idx, int[] prices, int state, int k)
//     {
//         // state 0 = buy or sell
//         // state 1 = buy
//         // state 2 = sell
//         if(idx >= prices.length)
//         {
//             if(state == 0)
//                 return 0;
//             return NEG_INF;
//         }   

//         long notTake = solve(idx + 1, prices, state, k);
//         long take = NEG_INF;
//         // buy or sell

//         if(k > 0){
//             if(state == 0)
//             {
//                 take = Math.max(prices[idx] + solve(idx + 1, prices, 2, k), -prices[idx] + solve(idx + 1, prices, 1, k));
//             }
            
//             else if(state == 1)
//             {
//                 take = Math.max(take, prices[idx] + solve(idx + 1, prices, 0, k - 1));
//             }

//             else
//                 take = Math.max(take, -prices[idx] + solve(idx +1, prices, 0, k - 1));
//         }

//         return Math.max(notTake, take);
//     }

//     public long maximumProfit(int[] prices, int k) {
//         return solve(0, prices, 0, k );
//     }
// }



class Solution {
    static final long NEG_INF = -(long)1e18;
    public long solve(int idx, int[] prices, int state, int k, long[][][] dp)
    {
        // state 0 = buy or sell
        // state 1 = buy
        // state 2 = sell
        if(idx >= prices.length)
        {
            if(state == 0)
                return 0;
            return NEG_INF;
        }

        if(dp[idx][k][state] != -1)
            return dp[idx][k][state]; 

        long notTake = solve(idx + 1, prices, state, k, dp);
        long take = NEG_INF;
        // buy or sell

        if(k > 0){
            if(state == 0)
            {
                take = Math.max(prices[idx] + solve(idx + 1, prices, 2, k, dp), -prices[idx] + solve(idx + 1, prices, 1, k, dp));
            }
            
            else if(state == 1)
            {
                take = Math.max(take, prices[idx] + solve(idx + 1, prices, 0, k - 1, dp));
            }

            else
                take = Math.max(take, -prices[idx] + solve(idx +1, prices, 0, k - 1, dp));
        }
        
        return dp[idx][k][state] = Math.max(notTake, take);
    }

    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][k + 1][3];

        for(long[][] arr1 : dp)
        {
            for(long[] arr : arr1)
                Arrays.fill(arr, -1);
        }
        return solve(0, prices, 0, k, dp);
    }
}
