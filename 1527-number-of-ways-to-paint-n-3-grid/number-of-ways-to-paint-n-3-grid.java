// class Solution {
//     int mod = 1000000007;

//     public int solve(int i, int j, int[][] grid)
//     {
//         int n = grid.length;

//         if(i == n)
//             return 1;
        
//         long ways = 0;

//         for(int color = 0; color <3; color++)
//         {
//             if(i > 0 && grid[i - 1][j] == color) continue;
//             if(j > 0 && grid[i][j - 1] == color) continue;

//             grid[i][j] = color;

//             int x = (j == 2) ? i + 1 : i;
//             int y = (j == 2) ? 0 : j + 1;

//             ways = (ways + solve(x, y, grid)) % mod;
//         }

//         return (int)ways;
//     }
//     public int numOfWays(int n) {
//         int[][] grid = new int[n][3];
//         return solve(0, 0, grid);
//     }
// }


// class Solution {
//     int mod = 1000000007;

//     public boolean isValid(int idx, int prev, int[][] patterns)
//     {
//         if(prev == -1)
//             return true;

//         for(int i = 0; i < 3; i++)
//         {
//             if(patterns[idx][i] == patterns[prev][i])
//                 return false;
//         }

//         return true;
//     }

//     public int solve(int i, int prev, int[][] grid, int[][] patterns)
//     {
//         int n = grid.length;

//         if(i == n)
//             return 1;
        
//         long ways = 0;

//         for(int color = 0; color < 12; color++)
//         {
//             if(isValid(color, prev, patterns))
//                 ways = (ways + solve(i + 1, color, grid, patterns)) % mod;
//         }

//         return (int)ways;
//     }
//     public int numOfWays(int n) {
//         int[][] grid = new int[n][3];
//         int[][] patterns = {
//             {0,1,0}, {1,0,1}, {2,0,1}, {0,1,2}, {1,0,2}, {2,0,2},
//             {0,2,0}, {1,2,0}, {2,1,0}, {0,2,1}, {1,2,1}, {2,1,2}
//         };
        

//         return solve(0, -1, grid, patterns);
//     }
// }



class Solution {
    int mod = 1000000007;

    public boolean isValid(int idx, int prev, int[][] patterns)
    {
        if(prev == -1)
            return true;

        for(int i = 0; i < 3; i++)
        {
            if(patterns[idx][i] == patterns[prev][i])
                return false;
        }

        return true;
    }

    public int solve(int i, int prev, int[][] dp, int[][] patterns)
    {
        int n = dp.length;

        if(i == n)
            return 1;
        
        if(prev != -1 && dp[i][prev] != -1)
            return dp[i][prev];

        
        long ways = 0;

        for(int color = 0; color < 12; color++)
        {
            if(isValid(color, prev, patterns))
                ways = (ways + solve(i + 1, color, dp, patterns)) % mod;
        }

        if (prev != -1)
            dp[i][prev] = (int) ways;

        return (int) ways;
    }
    public int numOfWays(int n) {
        int[][] dp = new int[n][12];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        int[][] patterns = {
            {0,1,0}, {1,0,1}, {2,0,1}, {0,1,2}, {1,0,2}, {2,0,2},
            {0,2,0}, {1,2,0}, {2,1,0}, {0,2,1}, {1,2,1}, {2,1,2}
        };
        
        

        return solve(0, -1, dp, patterns);
    }
}