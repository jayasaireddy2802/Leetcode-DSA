class Solution {
    public int largestSubmatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {

            // Build height histogram for each column
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && r > 0) {
                    grid[r][c] = grid[r][c] + grid[r - 1][c];
                }
            }

            // Copy current row and sort to maximize width
            int[] heights = new int[cols];
            for (int i = 0; i < cols; i++) {
                heights[i] = grid[r][i];
            }

            Arrays.sort(heights);

            // Calculate max area for this row
            for (int i = cols - 1; i >= 0; i--) {
                int height = heights[i];
                int width = cols - i;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}