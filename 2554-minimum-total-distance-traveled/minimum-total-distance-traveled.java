class Solution {

    private long dfs(int rIdx, int pIdx, List<Integer> robots, List<Integer> slots, long[][] dp) {
        // All robots assigned
        if (rIdx == robots.size()) return 0;

        // No slots left → invalid
        if (pIdx == slots.size()) return (long) 1e12;

        if (dp[rIdx][pIdx] != -1) return dp[rIdx][pIdx];

        // Option 1: Assign current robot to this slot
        long assign = Math.abs(robots.get(rIdx) - slots.get(pIdx))
                    + dfs(rIdx + 1, pIdx + 1, robots, slots, dp);

        // Option 2: Skip this slot
        long skip = dfs(rIdx, pIdx + 1, robots, slots, dp);

        return dp[rIdx][pIdx] = Math.min(assign, skip);
    }

    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {

        // Sort robots
        Collections.sort(robots);

        // Sort factories based on position
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);

        // Flatten factory capacity into positions list
        List<Integer> slots = new ArrayList<>();
        for (int[] f : factories) {
            int location = f[0];
            int capacity = f[1];

            while (capacity-- > 0) {
                slots.add(location);
            }
        }

        int r = robots.size();
        int s = slots.size();

        long[][] dp = new long[r][s];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, robots, slots, dp);
    }
}