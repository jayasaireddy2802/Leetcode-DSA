class Solution {

    private static final int MOD = (int) 1e9 + 7;

    // Fast modular exponentiation (binary exponentiation)
    private long modPow(long base, long exp) {
        long ans = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return ans;
    }

    public int xorAfterQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int threshold = (int) Math.sqrt(n) + 1;

        // Group queries having small step size
        Map<Integer, List<int[]>> grouped = new HashMap<>();

        // Handle large step queries directly
        for (int[] q : queries) {
            int left = q[0], right = q[1], step = q[2], val = q[3];

            if (step >= threshold) {
                for (int idx = left; idx <= right; idx += step) {
                    arr[idx] = (int) ((arr[idx] * 1L * val) % MOD);
                }
            } else {
                grouped.computeIfAbsent(step, k -> new ArrayList<>()).add(q);
            }
        }

        // Process queries with small step using difference technique
        for (Map.Entry<Integer, List<int[]>> entry : grouped.entrySet()) {
            int step = entry.getKey();
            List<int[]> qList = entry.getValue();

            long[] factor = new long[n];
            Arrays.fill(factor, 1);

            for (int[] q : qList) {
                int left = q[0], right = q[1], val = q[3];

                // Apply multiplication at start
                factor[left] = (factor[left] * val) % MOD;

                // Find position to cancel effect
                int count = (right - left) / step;
                int stop = left + (count + 1) * step;

                if (stop < n) {
                    long inverse = modPow(val, MOD - 2);
                    factor[stop] = (factor[stop] * inverse) % MOD;
                }
            }

            // Propagate values with step distance
            for (int i = 0; i < n; i++) {
                if (i - step >= 0) {
                    factor[i] = (factor[i] * factor[i - step]) % MOD;
                }
            }

            // Apply accumulated factors to array
            for (int i = 0; i < n; i++) {
                arr[i] = (int) ((arr[i] * 1L * factor[i]) % MOD);
            }
        }

        // Compute final XOR
        int xor = 0;
        for (int val : arr) {
            xor ^= val;
        }

        return xor;
    }
}