// class Solution {

//     int MOD = 1000000007;
//     int[] dirs_x = {1, 0};
//     int[] dirs_y = {0, 1};

//     public long[] solve(int x, int y, int[][] grid)
//     {
//         int rows = grid.length;
//         int cols = grid[0].length;

//         if(x == rows - 1 && y == cols - 1)
//             return new long[]{grid[x][y], grid[x][y]};

//         long max_val = Long.MIN_VALUE;
//         long min_val = Long.MAX_VALUE;

//         for(int i = 0; i < 2; i++)
//         {
//             int nx = x + dirs_x[i];
//             int ny = y + dirs_y[i];

//             if(nx >= rows || ny >= cols) continue;

//             long[] res = solve(x + dirs_x[i], y + dirs_y[i], grid);
//             long a = res[0] * grid[x][y];
//             long b = res[1] * grid[x][y];
            
//             min_val = Math.min(min_val, Math.min(a, b));
//             max_val = Math.max(max_val, Math.max(a, b));
//         }

//         return new long[]{max_val, min_val};
//     }

//     public int maxProductPath(int[][] grid) {
//         long[] ans = solve(0, 0, grid);

//         return (ans[0] < 0) ? -1 : (int)(ans[0] % MOD);
//     }
// }

class Solution {

    int MOD = 1000000007;
    int[] dirs_x = {1, 0};
    int[] dirs_y = {0, 1};

    public long[] solve(int x, int y, int[][] grid, long[][][] dp)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        if(x == rows - 1 && y == cols - 1)
            return new long[]{grid[x][y], grid[x][y]};

        if(dp[x][y][0] != Long.MIN_VALUE && dp[x][y][1] != Long.MAX_VALUE)
            return new long[]{dp[x][y][0], dp[x][y][1]};

        long max_val = Long.MIN_VALUE;
        long min_val = Long.MAX_VALUE;

        for(int i = 0; i < 2; i++)
        {
            int nx = x + dirs_x[i];
            int ny = y + dirs_y[i];

            if(nx >= rows || ny >= cols) continue;

            long[] res = solve(x + dirs_x[i], y + dirs_y[i], grid, dp);
            long a = res[0] * grid[x][y];
            long b = res[1] * grid[x][y];
            
            min_val = Math.min(min_val, Math.min(a, b));
            max_val = Math.max(max_val, Math.max(a, b));
        }

        dp[x][y][0] = max_val;
        dp[x][y][1] = min_val;

        return new long[]{max_val, min_val};
    }

    public int maxProductPath(int[][] grid) {

        long[][][] dp = new long[grid.length][grid[0].length][2];

        for(long[][] arr : dp)
        {
            for(long[] arr1 : arr)
            {
                arr1[0] = Long.MIN_VALUE;
                arr1[1] = Long.MAX_VALUE;
            }
        }

        long[] ans = solve(0, 0, grid, dp);

        return (ans[0] < 0) ? -1 : (int)(ans[0] % MOD);
    }
}
