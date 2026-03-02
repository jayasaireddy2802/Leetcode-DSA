class Solution {

    public int minSwaps(int[][] grid) {
        int size = grid.length;
        int[] lastOneIndex = new int[size];

        // Find the rightmost 1 in each row
        for (int row = 0; row < size; row++) {
            lastOneIndex[row] = -1;
            for (int col = size - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    lastOneIndex[row] = col;
                    break;
                }
            }
        }

        int swaps = 0;

        // Try to place a valid row at each position
        for (int target = 0; target < size; target++) {
            int candidate = target;

            while (candidate < size && lastOneIndex[candidate] > target) {
                candidate++;
            }

            // No valid row found
            if (candidate == size) {
                return -1;
            }

            // Bring the valid row up using adjacent swaps
            while (candidate > target) {
                int temp = lastOneIndex[candidate];
                lastOneIndex[candidate] = lastOneIndex[candidate - 1];
                lastOneIndex[candidate - 1] = temp;

                swaps++;
                candidate--;
            }
        }

        return swaps;
    }
}