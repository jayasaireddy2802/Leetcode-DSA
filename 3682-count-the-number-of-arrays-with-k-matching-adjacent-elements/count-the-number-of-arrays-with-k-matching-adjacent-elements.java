class Solution {
    int mod = 1000000007;

    // Fast modular exponentiation
    private long solve(long m, long n) {
        if (n == 0) return 1;  // FIXED: base case for exponent 0
        if (n == 1) return m % mod;
        long n1 = n / 2;
        long halfPower = solve(m, n1);
        long fullPower = (halfPower * halfPower) % mod;
        if (n % 2 == 1)
            fullPower = (fullPower * m) % mod;
        return fullPower;
    }

    // Modular inverse using Fermat’s Little Theorem
    private long modInverse(long x) {
        return solve(x, mod - 2);  // x^(mod-2) mod mod
    }

    public int countGoodArrays(int n, int m, int k) {
        int bag = n - k;
        if (bag <= 0) return 0;

        // Step 1: Compute m * (m - 1)^(bag - 1)
        long res1 = solve(m - 1, bag - 1);
        long res2 = (res1 * m) % mod;

        // Step 2: Compute (n - 1 choose k)
        long res3 = 1;
        for (int i = 0; i < k; i++) {
            res3 = (res3 * (n - 1 - i)) % mod;
        }

        // Step 3: Compute factorial for denominator
        long res4 = 1;
        for (int i = 1; i <= k; i++) {
            res4 = (res4 * i) % mod;
        }

        // Step 4: Compute modular inverse of denominator and finalize combination
        long res4Inv = modInverse(res4);
        res3 = (res3 * res4Inv) % mod;

        // Step 5: Final result calculation
        long ans = (res3 * res2) % mod;
        return (int) ans;
    }
}
