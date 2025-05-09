import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;
    int[] factorial, inverse, inverseFactorial;

    void precomputeFactorials(int maxVal) {
        factorial = new int[maxVal + 1];
        inverse = new int[maxVal + 1];
        inverseFactorial = new int[maxVal + 1];
        factorial[0] = inverse[0] = inverseFactorial[0] = 1;

        for (int i = 1; i <= maxVal; i++) {
            factorial[i] = (int) ((1L * factorial[i - 1] * i) % MOD);
        }

        inverse[1] = 1;
        for (int i = 2; i <= maxVal; i++) {
            inverse[i] = MOD - (int) ((1L * (MOD / i) * inverse[MOD % i]) % MOD);
        }

        for (int i = 1; i <= maxVal; i++) {
            inverseFactorial[i] = (int) ((1L * inverseFactorial[i - 1] * inverse[i]) % MOD);
        }
    }

    public int countBalancedPermutations(String input) {
        int totalDigits = input.length();
        int digitSum = 0;
        for (char digitChar : input.toCharArray()) {
            digitSum += digitChar - '0';
        }
        if (digitSum % 2 != 0) return 0;

        precomputeFactorials(totalDigits);
        int targetSum = digitSum / 2;
        int halfLength = totalDigits / 2;

        int[][] dp = new int[targetSum + 1][halfLength + 1];
        dp[0][0] = 1;

        int[] digitFrequency = new int[10];

        for (int i = 0; i < totalDigits; i++) {
            int digit = input.charAt(i) - '0';
            digitFrequency[digit]++;
            for (int sum = targetSum; sum >= digit; sum--) {
                for (int len = halfLength; len >= 1; len--) {
                    dp[sum][len] = (dp[sum][len] + dp[sum - digit][len - 1]) % MOD;
                }
            }
        }

        int result = dp[targetSum][halfLength];
        result = (int) (((1L * result * factorial[halfLength]) % MOD * factorial[totalDigits - halfLength]) % MOD);

        for (int count : digitFrequency) {
            result = (int) ((1L * result * inverseFactorial[count]) % MOD);
        }

        return result;
    }
}
