// class Solution {

//     public int solve(int i, int j, int neutralize, int[][] coins)
//     {
//         int m = coins.length;
//         int n = coins[0].length;

//         if(i < 0 || j < 0 || i >= m || j >= n)
//             return Integer.MIN_VALUE;

//         if(i == m - 1 && j == n - 1) {
//             if(coins[i][j] < 0 && neutralize > 0)
//                 return 0;
//             return coins[i][j];
//         }

        
//         int take = Integer.MIN_VALUE;

//         if(coins[i][j] < 0)
//         {
//             if(neutralize > 0)
//             {
//                 int val = Math.max(solve(i + 1, j, neutralize - 1, coins), solve(i, j + 1, neutralize - 1, coins));
//                 take = Math.max(take, val);
//                 val = coins[i][j] + Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins));
//                 take = Math.max(take, val);
//             }
//             else
//             {
//                 take = coins[i][j] + Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins));
//             }
            
//         }
//         else
//         {
//             take = coins[i][j] + Math.max(take, Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins)));
//         }

//         return take;

//     }

//     public int maximumAmount(int[][] coins) {
//         return solve(0, 0, 2, coins);
//     }
// }



class Solution {

    int[][][] dp;

    public int solve(int i, int j, int neutralize, int[][] coins)
    {
        int m = coins.length;
        int n = coins[0].length;

        if(i >= m || j >= n)
            return Integer.MIN_VALUE / 2;

        if(i == m - 1 && j == n - 1) {
            if(coins[i][j] < 0 && neutralize > 0)
                return 0;
            return coins[i][j];
        }

        if(dp[i][j][neutralize] != Integer.MIN_VALUE)
            return dp[i][j][neutralize];

        int take;

        if(coins[i][j] < 0)
        {
            if(neutralize > 0)
            {
                int val = Math.max(solve(i + 1, j, neutralize - 1, coins), solve(i, j + 1, neutralize - 1, coins));
                take = val;
                val = coins[i][j] + Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins));
                take = Math.max(take, val);
            }
            else
            {
                take = coins[i][j] + Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins));
            }
            
        }
        else
        {
            take = coins[i][j] + Math.max(solve(i + 1, j, neutralize, coins), solve(i, j + 1, neutralize, coins));
        }

        return dp[i][j][neutralize] = take;
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        dp = new int[m][n][3];

        for(int[][] layer : dp)
            for(int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);

        return solve(0, 0, 2, coins);
    }
}