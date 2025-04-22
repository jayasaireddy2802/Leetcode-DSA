class Solution {
    final int MOD = (int)1e9 + 7;

    void buildSequences(int currentValue, int[] sequenceCounts, int[][] lengthCountTable) {
        if (lengthCountTable[currentValue][1] != 0) return;

        lengthCountTable[currentValue][1] = 1;
        sequenceCounts[1]++;

        for (int divisor = 2; divisor <= currentValue; divisor++) {
            if (currentValue % divisor == 0) {
                buildSequences(currentValue / divisor, sequenceCounts, lengthCountTable);

                for (int length = 1; length < 15; length++) {
                    if (lengthCountTable[currentValue / divisor][length] != 0) {
                        lengthCountTable[currentValue][length + 1] =
                            (lengthCountTable[currentValue][length + 1] + lengthCountTable[currentValue / divisor][length]) % MOD;

                        sequenceCounts[length + 1] =
                            (sequenceCounts[length + 1] + lengthCountTable[currentValue / divisor][length]) % MOD;
                    }
                }
            }
        }
    }

    long fastPower(long base, long exponent) {
        if (exponent == 0) return 1;

        long half = fastPower(base, exponent / 2);
        long result = (half * half) % MOD;

        if (exponent % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }

    int nCrMod(int n, int r, long[] factorial) {
        if (r < 0 || r > n) return 0;

        long denom = (factorial[r] * factorial[n - r]) % MOD;
        return (int)((factorial[n] * fastPower(denom, MOD - 2)) % MOD);
    }

    public int idealArrays(int n, int maxValue) {
        int[][] lengthCountTable = new int[maxValue + 1][15]; // dp table: value x length
        int[] sequenceCounts = new int[15]; // number of sequences of each length

        for (int value = 1; value <= maxValue; value++) {
            buildSequences(value, sequenceCounts, lengthCountTable);
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        long total = 0;
        for (int length = 1; length < 15; length++) {
            if (n < length) break;
            if (sequenceCounts[length] != 0) {
                long combinations = nCrMod(n - 1, length - 1, factorial);
                total = (total + (sequenceCounts[length] * combinations) % MOD) % MOD;
            }
        }

        return (int)total;
    }
}
