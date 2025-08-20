// class Solution {

//     private int solve(int i, int j, int m, int n, int[][] matrix)
//     {
//         if(i >= m || j >= n || matrix[i][j] == 0)
//             return 0;
        
//         int right = solve(i, j+1, m, n, matrix);
//         int down = solve(i+1, j, m, n, matrix);
//         int diagnol = solve(i+1, j+1, m, n, matrix);

//         return 1 + Math.min(right, Math.min(down, diagnol));
//     }

//     public int countSquares(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int ans = 0;
//         for(int i = 0; i < m; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 ans += solve(i, j, m, n, matrix);
//             }
//         }

//         return ans;
//     }
// }


class Solution {

    private int solve(int i, int j, int m, int n, int[][] matrix, int[][] dp)
    {
        if(i >= m || j >= n || matrix[i][j] == 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j+1, m, n, matrix, dp);
        int down = solve(i+1, j, m, n, matrix, dp);
        int diagnol = solve(i+1, j+1, m, n, matrix, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(down, diagnol));
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int ans = 0;
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans += solve(i, j, m, n, matrix, dp);
            }
        }

        return ans;
    }
}