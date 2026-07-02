class Solution {

    int[] dirs_x = {-1, 0, 1, 0};
    int[] dirs_y = {0, 1, 0, -1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        // bestHealth[i][j] = max health we've managed to reach (i, j) with so far
        int[][] bestHealth = new int[m][n];
        for (int[] row : bestHealth) Arrays.fill(row, -1);

        int startHealth = health - grid.get(0).get(0); // (0,0) may itself be unsafe
        if (startHealth <= 0) return false;             // must stay positive

        bestHealth[0][0] = startHealth;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, startHealth});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], h = cur[2];

            if (i == m - 1 && j == n - 1)
                return h >= 1; // must arrive with health >= 1

            for (int k = 0; k < 4; k++) {
                int ni = i + dirs_x[k];
                int nj = j + dirs_y[k];

                if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                    continue;

                int nh = h - grid.get(ni).get(nj);

                if (nh <= 0)                        // can't move into a cell that drops you to 0 or below
                    continue;
                if (nh <= bestHealth[ni][nj])        // already reached with equal/better health
                    continue;

                bestHealth[ni][nj] = nh;
                queue.add(new int[]{ni, nj, nh});
            }
        }

        return false;
    }
}
