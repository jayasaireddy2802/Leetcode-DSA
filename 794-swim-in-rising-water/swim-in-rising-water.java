// class Solution {

//     int[] dirs_x = {-1, 0, 1, 0};
//     int[] dirs_y = {0, 1, 0, -1};
//     public boolean dfs(int i, int j, int t, int n, int[][] grid, boolean[][] visited)
//     {
//         if(i == n-1 && j == n-1)
//             return true;
//         if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] > t)
//             return false;

//         visited[i][j] = true;

//         for(int k = 0; k < 4; k++)
//         {
//             int x = i + dirs_x[k];
//             int y = j + dirs_y[k];

            
            
//             if(dfs(x, y, t, n, grid, visited))
//                 return true;
            
//         }

//         return false;

//     }

//     public int swimInWater(int[][] grid) {
        
//         int n = grid.length;
//         int t = n*n;

//         for(int i = 0; i <= t; i++)
//         {
//             boolean[][] visited = new boolean[n][n];

//             if(dfs(0, 0, i, n, grid, visited))
//             {
//                 return i;
//             }
//         }

//         return 0;
//     }
// }

class Solution {

    int[] dirs_x = {-1, 0, 1, 0};
    int[] dirs_y = {0, 1, 0, -1};
    public boolean dfs(int i, int j, int t, int n, int[][] grid, boolean[][] visited)
    {
        if(i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] > t)
            return false;
        if(i == n-1 && j == n-1)
            return true;

        visited[i][j] = true;

        for(int k = 0; k < 4; k++)
        {
            int x = i + dirs_x[k];
            int y = j + dirs_y[k];

            
            
            if(dfs(x, y, t, n, grid, visited))
                return true;
            
        }

        return false;

    }

    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int t = n*n;
        int i = 0, j = t;
        int ans = 0;

        while(i <= j)
        {
            int mid = (i + j)/2;
            boolean[][] visited = new boolean[n][n];

            if(dfs(0, 0, mid, n, grid, visited))
            {
                ans = mid;
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }

        return ans;
    }
}
