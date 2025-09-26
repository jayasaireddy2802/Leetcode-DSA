// class Solution {

//     public int solve(int i, int j, int rows, List<List<Integer>> triangle)
//     {
//         if(i == rows - 1)
//         {
//             return triangle.get(i).get(j);
//         }

//         int left = solve(i + 1, j, rows, triangle);
//         int right = solve(i + 1, j + 1, rows, triangle);

//         return triangle.get(i).get(j) + Math.min(left, right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int rows = triangle.size();

//         return solve(0, 0, rows, triangle);
//     }
// }


// class Solution {

//     public int solve(int i, int j, int rows, List<List<Integer>> triangle, int[][] dp)
//     {
//         if(i == rows - 1)
//         {
//             return triangle.get(i).get(j);
//         }

//         if(dp[i][j] != -1)
//             return dp[i][j];

//         int left = solve(i + 1, j, rows, triangle, dp);
//         int right = solve(i + 1, j + 1, rows, triangle, dp);

//         return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int rows = triangle.size();
//         int[][] dp = new int[rows][rows];
//         for(int[] arr : dp)
//             Arrays.fill(arr, -1);
//         return solve(0, 0, rows, triangle, dp);
//     }
// }


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Start with last row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }
        
        // Build from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }
}


