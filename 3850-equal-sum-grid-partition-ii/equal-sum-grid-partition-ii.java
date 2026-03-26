import java.util.*;

class Solution {

    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        long totalSum = 0;

        long[] rowSum = new long[rows];
        long[] colSum = new long[cols];

        Map<Integer, List<int[]>> map = new HashMap<>();

        // Build sums + map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];

                totalSum += val;
                rowSum[i] += val;
                colSum[j] += val;

                map.computeIfAbsent(val, k -> new ArrayList<>())
                   .add(new int[]{i, j});
            }
        }

        // -------- HORIZONTAL CUT --------
        long topSum = 0;

        for (int i = 0; i < rows - 1; i++) {
            topSum += rowSum[i];
            long bottomSum = totalSum - topSum;

            if (topSum == bottomSum) return true;

            long diff = Math.abs(topSum - bottomSum);
            boolean removeFromTop = topSum > bottomSum;

            if (diff > Integer.MAX_VALUE) continue;  // fix 1
            if (!map.containsKey((int) diff)) continue;  // fix 1

            for (int[] pos : map.get((int) diff)) {  // fix 1
                int r = pos[0], c = pos[1];

                if (removeFromTop) {
                    if (r <= i) {
                        int height = i + 1;

                        if (height == 1) {
                            if (c == 0 || c == cols - 1) return true;
                        } else if (cols == 1) {  // fix 2
                            if (r == 0 || r == i) return true;  // fix 2
                        } else {
                            return true;
                        }
                    }
                } else {
                    if (r > i) {
                        int height = rows - (i + 1);

                        if (height == 1) {
                            if (c == 0 || c == cols - 1) return true;
                        } else if (cols == 1) {  // fix 2
                            if (r == i + 1 || r == rows - 1) return true;  // fix 2
                        } else {
                            return true;
                        }
                    }
                }
            }
        }

        // -------- VERTICAL CUT --------
        long leftSum = 0;

        for (int j = 0; j < cols - 1; j++) {
            leftSum += colSum[j];
            long rightSum = totalSum - leftSum;

            if (leftSum == rightSum) return true;

            long diff = Math.abs(leftSum - rightSum);
            boolean removeFromLeft = leftSum > rightSum;

            if (diff > Integer.MAX_VALUE) continue;  // fix 1
            if (!map.containsKey((int) diff)) continue;  // fix 1

            for (int[] pos : map.get((int) diff)) {  // fix 1
                int r = pos[0], c = pos[1];

                if (removeFromLeft) {
                    if (c <= j) {
                        int width = j + 1;

                        if (width == 1) {
                            if (r == 0 || r == rows - 1) return true;
                        } else if (rows == 1) {  // fix 2
                            if (c == 0 || c == j) return true;  // fix 2
                        } else {
                            return true;
                        }
                    }
                } else {
                    if (c > j) {
                        int width = cols - (j + 1);

                        if (width == 1) {
                            if (r == 0 || r == rows - 1) return true;
                        } else if (rows == 1) {  // fix 2
                            if (c == j + 1 || c == cols - 1) return true;  // fix 2
                        } else {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}