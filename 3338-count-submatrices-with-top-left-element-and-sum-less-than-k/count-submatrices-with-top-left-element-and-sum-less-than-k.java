// class Solution {
//     public int countSubmatrices(int[][] grid, int k) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int ans = 0;

//         for(int i = 0; i < rows; i++)
//         {
//             for(int j = 0; j < cols; j++)
//             {
//                 int sum = 0;

//                 op:
//                 for(int m = 0; m <= i; m++)
//                 {
//                     for(int n = 0; n <= j; n++)
//                     {
//                         sum += grid[m][n];
//                         if(sum > k)
//                             break op;
//                     }
//                 }

//                 if(sum <= k)
//                     ans++;
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        int[][] prefixSum = new int[rows + 1][cols + 1];

        for(int i = 1; i <= rows; i++)
        {
            for(int j = 1; j <= cols; j++)
            {
                prefixSum[i][j] = grid[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
                if(prefixSum[i][j] <= k)
                    ans++;
                else
                    break ;
            }
        }

        return ans;
    }
}