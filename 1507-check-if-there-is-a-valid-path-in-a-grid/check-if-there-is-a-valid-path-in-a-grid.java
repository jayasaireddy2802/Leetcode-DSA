class Solution {

    private int rows, cols;
    private Map<Integer, int[][]> moves;

    public Solution() {
        moves = new HashMap<>();

        moves.put(1, new int[][]{{0, -1}, {0, 1}});   // left, right
        moves.put(2, new int[][]{{-1, 0}, {1, 0}});   // up, down
        moves.put(3, new int[][]{{0, -1}, {1, 0}});   // left, down
        moves.put(4, new int[][]{{0, 1}, {1, 0}});    // right, down
        moves.put(5, new int[][]{{0, -1}, {-1, 0}});  // left, up
        moves.put(6, new int[][]{{-1, 0}, {0, 1}});   // up, right
    }

    private boolean explore(int[][] grid, int r, int c, boolean[][] seen) {

        if (r == rows - 1 && c == cols - 1) {
            return true;
        }

        seen[r][c] = true;

        for (int[] step : moves.get(grid[r][c])) {
            int nr = r + step[0];
            int nc = c + step[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || seen[nr][nc]) {
                continue;
            }

            // verify reverse connection
            for (int[] rev : moves.get(grid[nr][nc])) {
                if (nr + rev[0] == r && nc + rev[1] == c) {
                    if (explore(grid, nr, nc, seen)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] seen = new boolean[rows][cols];
        return explore(grid, 0, 0, seen);
    }
}