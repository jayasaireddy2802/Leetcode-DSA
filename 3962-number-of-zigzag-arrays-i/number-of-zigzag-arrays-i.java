import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1; // range size

        // dp arrays
        int[][] up = new int[n + 1][m];
        int[][] down = new int[n + 1][m];

        // Base case: length = 2
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                if (x == y) continue;
                if (x < y) {
                    up[2][y] = (up[2][y] + 1) % MOD;
                } else {
                    down[2][y] = (down[2][y] + 1) % MOD;
                }
            }
        }

        // DP for length 3 to n
        for (int i = 3; i <= n; i++) {
            int[] prefUp = new int[m + 1];
            int[] prefDown = new int[m + 1];

            // Build prefix sums
            for (int v = 0; v < m; v++) {
                prefUp[v + 1] = (prefUp[v] + up[i - 1][v]) % MOD;
                prefDown[v + 1] = (prefDown[v] + down[i - 1][v]) % MOD;
            }

            for (int y = 0; y < m; y++) {
                // up[i][y] = sum of down[i-1][x] for x < y
                up[i][y] = prefDown[y];

                // down[i][y] = sum of up[i-1][x] for x > y
                down[i][y] = (int)(((long)prefUp[m] - prefUp[y + 1] + MOD) % MOD);
            }
        }

        long ans = 0;

        if (n == 1) {
            return m;
        }

        for (int y = 0; y < m; y++) {
            ans = (ans + up[n][y] + down[n][y]) % MOD;
        }

        return (int) ans;
    }
}