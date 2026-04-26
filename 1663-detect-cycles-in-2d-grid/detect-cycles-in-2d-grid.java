class Solution {
    int[] dirs_x = {-1, 0, 1, 0};
    int[] dirs_y = {0, 1, 0, -1};
    boolean[][] visited;

    public boolean dfs(int i, int j, int prev_i, int prev_j, char ch, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited[i][j] = true;

        for (int dir = 0; dir < 4; dir++) {
            int new_x = i + dirs_x[dir];
            int new_y = j + dirs_y[dir];

            if (new_x >= 0 && new_x < rows && new_y >= 0 && new_y < cols) {
                if (ch == grid[new_x][new_y]) {
                    if (new_x == prev_i && new_y == prev_j) continue;

                    if (!visited[new_x][new_y]) {
                        if (dfs(new_x, new_y, i, j, ch, grid))
                            return true;
                    } else return true; 
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j], grid))
                        return true;
                }
            }
        }
        return false;
    }
}