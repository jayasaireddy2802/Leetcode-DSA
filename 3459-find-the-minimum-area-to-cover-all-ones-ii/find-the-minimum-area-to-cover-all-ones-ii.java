// class Solution {

//     private int minimumArea(int startRow, int endRow, int startCol, int endCol, int[][] grid)
//     {
//         int start_row_index = 50;
//         int end_row_index = -1;
//         int start_col_index = 50;
//         int end_col_index = -1;

//         for(int i = startRow; i < endRow; i++)
//         {
//             for(int j = startCol; j < endCol; j++)
//             {
//                 if(grid[i][j] == 1)
//                 {
//                     start_row_index = Math.min(start_row_index, i);
//                     start_col_index = Math.min(start_col_index, j);
//                     end_row_index = Math.max(end_row_index, i);
//                     end_col_index = Math.max(end_col_index, j);
//                 }
//             }
//         }

//         if(start_row_index == 50 || end_row_index == -1 || start_col_index == 50 || end_col_index == -1)
//             return 0;
//         return (end_row_index - start_row_index + 1) * (end_col_index - start_col_index + 1);
//     }

//     private int findArea(int[][] grid)
//     {
//         int m = grid.length;
//         int n = grid[0].length;
//         int result = Integer.MAX_VALUE;

//         // case 1:

//         for(int row_split = 1; row_split < m; row_split++)
//         {
//             for(int col_split = 1; col_split < n; col_split++)
//             {
//                 int topArea = minimumArea(0, row_split, 0, n, grid);
//                 int leftArea = minimumArea(row_split, m, 0, col_split, grid);
//                 int rightArea = minimumArea(row_split, m, col_split, n, grid);

//                 result = Math.min(result, topArea + rightArea + leftArea);
//             }
//         }

//         // case 2:

//         for(int row_split = 1; row_split < m; row_split++)
//         {
//             for(int col_split = 1; col_split < n; col_split++)
//             {
//                 int bottomArea = minimumArea(row_split, m, 0, n, grid);
//                 int leftArea = minimumArea(0, row_split, 0, col_split, grid);
//                 int rightArea = minimumArea(0, row_split, col_split, n, grid);

//                 result = Math.min(result, bottomArea + rightArea + leftArea);
//             }
//         }

//         // case 3 :

//         for(int row_split1 = 1; row_split1 < m; row_split1++)
//         {
//             for(int row_split2 = 1; row_split2 < m; row_split2++)
//             {
//                 int topArea = minimumArea(0, row_split1, 0, n, grid);
//                 int middleArea = minimumArea(row_split1, row_split2, 0, n, grid);
//                 int bottomArea = minimumArea(row_split2, m, 0, n, grid);

//                 result = Math.min(result, topArea + middleArea + bottomArea);
//             }
//         }

//         return result;
//     }

//     private int[][] rotateGrid(int[][] grid)
//     {
//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] rotated = new int[n][m];
//         for(int i = 0; i < m; i++)
//         {
//             for(int j = 0; j < n; j++)
//             {
//                 rotated[j][i] = grid[i][j];
//             }
//         }

//         return rotated;
//     }

//     public int minimumSum(int[][] grid) {

//         int res1 = findArea(grid);
//         int[][] rotatedGrid = rotateGrid(grid);
//         int res2 = findArea(rotatedGrid);
//         return Math.min(res1, res2);        
//     }
// }


class Solution {

    private int minimumArea(int startRow, int endRow, int startCol, int endCol, int[][] grid)
    {
        int start_row_index = 50;
        int end_row_index = -1;
        int start_col_index = 50;
        int end_col_index = -1;

        for(int i = startRow; i < endRow; i++)
        {
            for(int j = startCol; j < endCol; j++)
            {
                if(grid[i][j] == 1)
                {
                    start_row_index = Math.min(start_row_index, i);
                    start_col_index = Math.min(start_col_index, j);
                    end_row_index = Math.max(end_row_index, i);
                    end_col_index = Math.max(end_col_index, j);
                }
            }
        }

        if(start_row_index == 50 || end_row_index == -1 || start_col_index == 50 || end_col_index == -1)
            return 0;
        return (end_row_index - start_row_index + 1) * (end_col_index - start_col_index + 1);
    }

    private int findArea(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int result = Integer.MAX_VALUE;

        // case 1:

        for(int row_split = 1; row_split < m; row_split++)
        {
            for(int col_split = 1; col_split < n; col_split++)
            {
                int topArea = minimumArea(0, row_split, 0, n, grid);
                int leftArea = minimumArea(row_split, m, 0, col_split, grid);
                int rightArea = minimumArea(row_split, m, col_split, n, grid);

                result = Math.min(result, topArea + rightArea + leftArea);

                int bottomArea = minimumArea(row_split, m, 0, n, grid);
                leftArea = minimumArea(0, row_split, 0, col_split, grid);
                rightArea = minimumArea(0, row_split, col_split, n, grid);

                result = Math.min(result, bottomArea + rightArea + leftArea);
            }
        }

        for(int row_split1 = 1; row_split1 < m; row_split1++)
        {
            for(int row_split2 = 1; row_split2 < m; row_split2++)
            {
                int topArea = minimumArea(0, row_split1, 0, n, grid);
                int middleArea = minimumArea(row_split1, row_split2, 0, n, grid);
                int bottomArea = minimumArea(row_split2, m, 0, n, grid);

                result = Math.min(result, topArea + middleArea + bottomArea);
            }
        }

        return result;
    }

    private int[][] rotateGrid(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rotated = new int[n][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                rotated[j][i] = grid[i][j];
            }
        }

        return rotated;
    }

    public int minimumSum(int[][] grid) {

        int res1 = findArea(grid);
        int[][] rotatedGrid = rotateGrid(grid);
        int res2 = findArea(rotatedGrid);
        return Math.min(res1, res2);        
    }
}