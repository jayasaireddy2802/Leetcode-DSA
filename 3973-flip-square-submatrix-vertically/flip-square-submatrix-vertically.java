class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        // 1, 0 -> 3,0
        // 2, 0
        for(int i = x; i < x+k/2; i++)
        {
            for(int j = y; j < y + k; j++)
            {
                int temp = grid[i][j];
                grid[i][j] = grid[(2*x+k-1) - i][j];
                grid[(2*x+k-1) - i][j] = temp;
            }
        }
        
        return grid;
    }
}