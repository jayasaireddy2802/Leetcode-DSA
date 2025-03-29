import java.util.*;

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    private int countPrimeFactors(int n) {
        int cnt = 0;

        if (n % 2 == 0) {
            cnt++;
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                cnt++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) 
            cnt++;

        return cnt;
    }

    private long modPow(long x, long y) {
        if (y == 0)
            return 1;
        long p = modPow(x, y / 2) % MOD;
        p = (p * p) % MOD;
        return (y % 2 == 1) ? (p * x) % MOD : p;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeFactors = new int[n];

        for (int i = 0; i < n; i++) {
            primeFactors[i] = countPrimeFactors(nums.get(i));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0]) // Max-heap based on nums[i]
        );

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums.get(i), i});
        }

        long score = 1;

        while (k > 0) {
            int[] top = pq.poll();
            int maxVal = top[0];
            int ind = top[1];
            int i = ind - 1;
            int maxCount = primeFactors[ind];

            int cnt1 = 0;
            while (ind < n && primeFactors[ind] <= maxCount) {
                cnt1++;
                ind++;
            }

            int cnt2 = 1;
            while (i >= 0 && primeFactors[i] < maxCount) {
                cnt2++;
                i--;
            }

            long take = Math.min(k, (long) cnt1 * cnt2);
            k -= take;

            score = (score * modPow(maxVal, take)) % MOD;

            if (k == 0) 
                break;
        }

        return (int) score;
    }
}
