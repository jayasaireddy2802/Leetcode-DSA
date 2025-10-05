public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacReach = new boolean[rows][cols];
        boolean[][] atlReach = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacReach, Integer.MIN_VALUE, r, 0);
            dfs(heights, atlReach, Integer.MIN_VALUE, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacReach, Integer.MIN_VALUE, 0, c);
            dfs(heights, atlReach, Integer.MIN_VALUE, rows - 1, c);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacReach[r][c] && atlReach[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] heights, boolean[][] visited, int prevHeight, int row, int col) {
        int rows = heights.length, cols = heights[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || heights[row][col] < prevHeight)
            return;

        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(heights, visited, heights[row][col], row + dir[0], col + dir[1]);
        }
    }
}
