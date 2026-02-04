class Solution {

    int length;
    long[][] dp;
    static final long NEGATIVE_INFINITY = Long.MIN_VALUE / 2;

    long solve(int index, int state, int[] nums) {
        if (index == length) {
            return (state == 3) ? 0 : NEGATIVE_INFINITY;
        }

        if (dp[index][state] != Long.MIN_VALUE) {
            return dp[index][state];
        }

        long pickSum = NEGATIVE_INFINITY;
        long skipSum = NEGATIVE_INFINITY;

        // Skip (only before sequence starts)
        if (state == 0) {
            skipSum = solve(index + 1, 0, nums);
        }

        // If trionic pattern already completed, we can end here
        if (state == 3) {
            pickSum = nums[index];
        }

        if (index + 1 < length) {
            int current = nums[index];
            int nextVal = nums[index + 1];

            if (state == 0 && nextVal > current) {
                pickSum = Math.max(pickSum, current + solve(index + 1, 1, nums));
            }
            else if (state == 1) {
                if (nextVal > current) {
                    pickSum = Math.max(pickSum, current + solve(index + 1, 1, nums));
                } else if (nextVal < current) {
                    pickSum = Math.max(pickSum, current + solve(index + 1, 2, nums));
                }
            }
            else if (state == 2) {
                if (nextVal < current) {
                    pickSum = Math.max(pickSum, current + solve(index + 1, 2, nums));
                } else if (nextVal > current) {
                    pickSum = Math.max(pickSum, current + solve(index + 1, 3, nums));
                }
            }
            else if (state == 3 && nextVal > current) {
                pickSum = Math.max(pickSum, current + solve(index + 1, 3, nums));
            }
        }

        return dp[index][state] = Math.max(pickSum, skipSum);
    }

    public long maxSumTrionic(int[] nums) {
        length = nums.length;
        dp = new long[length][4];

        // Initialize dp with "uncomputed"
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        return solve(0, 0, nums);
    }
}
