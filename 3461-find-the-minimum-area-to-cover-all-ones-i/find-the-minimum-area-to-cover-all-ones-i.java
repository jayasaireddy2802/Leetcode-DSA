class Solution {

    public int minimumArea(int[][] grid) {
       
       int m = grid.length;
       int n = grid[0].length;

       int i_idx_max = -1;
       int j_idx_max = -1;
       int i_idx_min = 10000;
       int j_idx_min = 10000;

       for(int i = 0; i < m; i++)
       {
            for(int j = 0; j< n; j++)
            {
                if(grid[i][j] == 1)
                {
                    i_idx_max = Math.max(i_idx_max, i);
                    j_idx_max = Math.max(j_idx_max, j);
                    i_idx_min= Math.min(i_idx_min, i);
                    j_idx_min = Math.min(j_idx_min, j);
                }
            }
       }

        if(i_idx_max == -1 || j_idx_max == -1 || i_idx_min == 10000 || j_idx_max == 10000)
            return 0;
       
            return (i_idx_max - i_idx_min + 1) * (j_idx_max - j_idx_min + 1);
    }
}
