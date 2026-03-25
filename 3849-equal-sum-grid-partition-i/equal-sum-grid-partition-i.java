class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long[] rowWiseSum = new long[rows];
        long[] columnWiseSum = new long[cols];
        long totalSum = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                rowWiseSum[i] = rowWiseSum[i] + grid[i][j];
                totalSum += grid[i][j];
            }
        }

        for(int j = 0; j < cols; j++)
        {
            for(int i = 0; i < rows; i++)
            {
                columnWiseSum[j] = columnWiseSum[j] + grid[i][j];
            }
        }

        long sum = rowWiseSum[0];
        for(int i = 1; i < rows; i++)
        {
            if(sum == totalSum - sum)
                return true;

            sum += rowWiseSum[i];
        }

        sum = columnWiseSum[0];
        for(int i = 1; i < cols; i++)
        {
            if(sum == totalSum - sum)
                return true;
            sum += columnWiseSum[i];
        }


        return false;
    }
}