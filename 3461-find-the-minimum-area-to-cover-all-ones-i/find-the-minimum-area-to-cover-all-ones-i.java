class Solution {

    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int top = rows, bottom = -1, left = cols, right = -1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r < top) top = r;
                    if (r > bottom) bottom = r;
                    if (c < left) left = c;
                    if (c > right) right = c;
                }
            }
        }

        // If no '1' found, area = 0
        if (bottom == -1) return 0;

        int height = bottom - top + 1;
        int width = right - left + 1;
        return height * width;
    }
}
