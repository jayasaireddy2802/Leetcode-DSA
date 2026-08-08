class Solution {

    private String buildNumber(long targetFactor, int length) {
        StringBuilder result = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (targetFactor % d == 0) {
                result.append((char) ('0' + d));
                targetFactor /= d;
            }
        }

        while (result.length() < length) {
            result.append('1');
        }

        return result.reverse().toString();
    }

    public String smallestNumber(String num, long t) {
        int len = num.length();

        long temp = t;
        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            while (temp % p == 0) {
                temp /= p;
            }
        }

        
        if (temp != 1) return "-1";

        
        long[] remaining = new long[len + 1];
        remaining[0] = t;

        for (int i = 0; i < len; i++) {
            int digit = num.charAt(i) - '0';

            if (digit == 0) break;

            remaining[i + 1] = remaining[i] / gcd(remaining[i], digit);
        }

       
        if (remaining[len] == 1) return num;

        
        int firstZero = num.indexOf('0');
        int start = (firstZero == -1) ? len - 1 : firstZero;

        for (int i = start; i >= 0; i--) {
            long needed = remaining[i];
            int slots = len - i - 1;

            for (int nextDigit = (num.charAt(i) - '0') + 1; nextDigit <= 9; nextDigit++) {
                long newNeeded = needed / gcd(needed, nextDigit);

                String suffix = buildNumber(newNeeded, slots);

                if (suffix.length() == slots) {
                    return num.substring(0, i) + (char) ('0' + nextDigit) + suffix;
                }
            }
        }

        return buildNumber(t, len + 1);
    }

    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}