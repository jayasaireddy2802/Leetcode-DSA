// class Solution {

//     public int solve(int i, int j, int[][] grid, int k, int cost)
//     {
//         int rows = grid.length;
//         int cols = grid[0].length;

//         if(i < 0 || i >= rows || j < 0 || j >= cols) 
//             return Integer.MIN_VALUE;

//         int newCost = cost + ((grid[i][j] > 0) ? 1 : 0);

//         if(newCost > k) 
//             return Integer.MIN_VALUE;

//         if(i == rows - 1 && j == cols - 1) {
//             return grid[i][j];
//         }

//         int down = solve(i + 1, j, grid, k, newCost);
//         int right = solve(i, j + 1, grid, k, newCost);

//         if(down == Integer.MIN_VALUE && right == Integer.MIN_VALUE)
//             return Integer.MIN_VALUE;

//         return Math.max(down, right) + grid[i][j];
//     }

//     public int maxPathScore(int[][] grid, int k) {
//         int ans = solve(0, 0, grid, k, 0);
//         return (ans == Integer.MIN_VALUE) ? -1 : ans; 

        
//     }
// }


class Solution {

    public int solve(int i, int j, int[][] grid, int k, int cost, int[][][] dp)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        if(i < 0 || i >= rows || j < 0 || j >= cols) 
            return Integer.MIN_VALUE;

        if(dp[i][j][cost] != -1)
            return dp[i][j][cost];

        int newCost = cost + ((grid[i][j] > 0) ? 1 : 0);

        if(newCost > k) 
            return Integer.MIN_VALUE;

        if(i == rows - 1 && j == cols - 1) {
            return grid[i][j];
        }

        int down = solve(i + 1, j, grid, k, newCost, dp);
        int right = solve(i, j + 1, grid, k, newCost, dp);

        if(down == Integer.MIN_VALUE && right == Integer.MIN_VALUE){
            dp[i][j][cost] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        return dp[i][j][cost] = Math.max(down, right) + grid[i][j];
    }

    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] arr1 : dp)
        {
            for(int[]arr : arr1)
                Arrays.fill(arr, -1);
        }
        int ans = solve(0, 0, grid, k, 0, dp);
        return (ans == Integer.MIN_VALUE) ? -1 : ans; 

        
    }
}