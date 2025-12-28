// class Solution {
//     public int countNegatives(int[][] grid) {
//         int ans = 0;
//         int rows = grid.length;
//         int cols = grid[0].length;

//         for(int i = 0; i < rows; i++)
//         {
//             for(int j = 0; j < cols; j++)
//             {
//                 if(grid[i][j] < 0)
//                     ans++;
//             }
//         }

//         return ans;
//     }
// }


// class Solution {
//     public int binarySearch(int r, int[][] grid)
//     {
//         int cols = grid[0].length;
//         int i = 0, j = cols - 1;
//         int idx = cols;

//         while(i <= j)
//         {
//             int mid = (i + j)/2;

//             if(grid[r][mid] < 0)
//             {
//                 idx = mid;
//                 j = mid - 1;
//             }
//             else
//                 i = mid + 1;
//         }

//         return cols - idx;
//     }

//     public int countNegatives(int[][] grid) {
//         int ans = 0;
//         int rows = grid.length;
        
//         for(int i = 0; i < rows; i++)
//         {
//             int ct = binarySearch(i, grid);
//             ans += ct;
//         }

//         return ans;
//     }
// }




class Solution {
    public int binarySearch(int r, int[][] grid)
    {
        int cols = grid[0].length;
        int i = 0, j = cols - 1;
        int idx = cols;

        while(i <= j)
        {
            int mid = (i + j)/2;

            if(grid[r][mid] < 0)
            {
                idx = mid;
                j = mid - 1;
            }
            else
                i = mid + 1;
        }

        return cols - idx;
    }

    public int countNegatives(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int row = rows - 1;
        int col = 0;

        while(col < cols && row >= 0)
        {
            if(grid[row][col] >= 0)
            {
                col++;
            }
            else
            {
                ans += (cols - col);
                row--;
            }
        }

        return ans;
    }
}