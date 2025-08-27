import java.util.Arrays;

class Solution {

    private static final int[][] MOVES = {
        { 1, 1 },    // down-right
        { 1, -1 },   // down-left
        { -1, -1 },  // up-left
        { -1, 1 }    // up-right
    };

    private int[][][][] cache;
    private int[][] board;
    private int rows, cols;

    public int lenOfVDiagonal(int[][] matrix) {
        this.board = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.cache = new int[rows][cols][4][2];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int d = 0; d < 4; d++) {
                    Arrays.fill(cache[r][c][d], -1);
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        answer = Math.max(answer, explore(r, c, dir, true, 2) + 1);
                    }
                }
            }
        }
        return answer;
    }

    private int explore(int x, int y, int dir, boolean canTurn, int expected) {
        int nextX = x + MOVES[dir][0];
        int nextY = y + MOVES[dir][1];

        // Stop if out of bounds or mismatch in expected value
        if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols || board[nextX][nextY] != expected) {
            return 0;
        }

        int turnFlag = canTurn ? 1 : 0;
        if (cache[nextX][nextY][dir][turnFlag] != -1) {
            return cache[nextX][nextY][dir][turnFlag];
        }

        // Continue in same direction
        int best = explore(nextX, nextY, dir, canTurn, 2 - expected);

        // Try a clockwise turn if still allowed
        if (canTurn) {
            best = Math.max(best, explore(nextX, nextY, (dir + 1) % 4, false, 2 - expected));
        }

        cache[nextX][nextY][dir][turnFlag] = best + 1;
        return best + 1;
    }
}
