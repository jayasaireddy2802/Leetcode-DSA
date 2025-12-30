class Solution {

    public boolean isMagic(int i, int j, int[][] grid) {
        int sum = -1;

        boolean[] seen = new boolean[10];

        // check 1..9 and distinct
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                int v = grid[i + m][j + n];
                if (v < 1 || v > 9 || seen[v])
                    return false;
                seen[v] = true;
            }
        }

        // row sum
        for (int m = 0; m < 3; m++) {
            int val = 0;
            for (int n = 0; n < 3; n++) {
                if (grid[m + i][n + j] > 9)
                    return false;
                val += grid[m + i][n + j];
            }

            if (sum == -1)
                sum = val;
            if (sum != val) {
                return false;
            }
        }

        // col sum
        for (int n = 0; n < 3; n++) {
            int val = 0;
            for (int m = 0; m < 3; m++) {
                if (grid[m + i][n + j] > 9)
                    return false;
                val += grid[m + i][n + j];
            }
            if (sum != val) {
                return false;
            }
        }

        // right diagonal
        int val = 0;
        for (int m = 0; m < 3; m++) {
            if (grid[i + m][j + m] > 9)
                return false;
            val += grid[i + m][j + m];
        }
        if (sum != val) {
            return false;
        }

        val = 0;
        for (int m = 0; m < 3; m++) {
            if (grid[i + m][j + 2 - m] > 9)
                return false;
            val += grid[i + m][j + 2 - m];
        }
        if (sum != val)
            return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ct = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagic(i, j, grid))
                    ct++;
            }
        }

        return ct;
    }
}