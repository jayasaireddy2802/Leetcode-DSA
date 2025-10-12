// class Solution {

//     long result = 0;
//     long mod = 1000_000_007;

//     public int setBits(Long num)
//     {
//         int ct = 0;
//         while(num > 0)
//         {
//             if((num & 1) != 0)
//                 ct++;
//             num = num >> 1;
//         }
//         return ct;
//     }

//     public long getArrayProduct(List<Integer> list, int[] nums, int k)
//     {
//         long sum = 0;
//         long ans = 1;
//         for(int num : list)
//         {
//             sum = sum + (long)Math.pow(2, num);
//         }
//         int ct = setBits(sum);
//         if(ct == k)
//         {
//             for(int num : list)
//                 ans = ans*nums[num];
//             return ans;
//         }
//         else return 0;
//     }

//     public void generateSubsequences(int m, int n, int k, int[] nums, List<Integer> list)
//     {
//         if(list.size() == m)
//         {
//             long val = getArrayProduct(list, nums, k);
//             result = (result % mod + val % mod) % mod;
//             return ;
//         }
            
        

//         for(int i = 0; i < n; i++)
//         {
//             list.add(i);
//             generateSubsequences(m, n, k, nums, list);
//             list.remove(list.size() - 1);
//         }
//     }

//     public int magicalSum(int m, int k, int[] nums) {
        
//         int n = nums.length;
//         result = 0;
//         generateSubsequences(m, n, k, nums, new ArrayList<>());

//         return (int)result;
//     }
// }


// class Solution {

//     long result = 0;
//     long mod = 1000_000_007;

//     public int setBits(Long num)
//     {
//         int ct = 0;
//         while(num > 0)
//         {
//             if((num & 1) != 0)
//                 ct++;
//             num = num >> 1;
//         }
//         return ct;
//     }

//     public long getArrayProduct(List<Integer> list, int[] nums, int k)
//     {
//         long sum = 0;
//         long ans = 1;
//         for(int num : list)
//         {
//             // sum = sum + (long)Math.pow(2, num);
//             sum = sum + (1l << num);
//         }
//         int ct = setBits(sum);
//         if(ct == k)
//         {
//             for(int num : list)
//                 ans = ans*nums[num];
//             return ans;
//         }
//         else return 0;
//     }

//     public void generateSubsequences(int m, int n, int k, int[] nums, List<Integer> list)
//     {
//         if(list.size() == m)
//         {
//             long val = getArrayProduct(list, nums, k);
//             result = (result % mod + val % mod) % mod;
//             return ;
//         }
            
        

//         for(int i = 0; i < n; i++)
//         {
//             list.add(i);
//             generateSubsequences(m, n, k, nums, list);
//             list.remove(list.size() - 1);
//         }
//     }

//     public int magicalSum(int m, int k, int[] nums) {
        
//         int n = nums.length;
//         result = 0;
//         generateSubsequences(m, n, k, nums, new ArrayList<>());

//         return (int)result;
//     }
// }


// import java.math.BigInteger;

// class Solution {

//     long result = 0L;
//     final long MOD = 1_000_000_007L;

//     // Use BigInteger for safe bit counts when large shifts/carries happen
//     // count bits in BigInteger:
//     private int bitCount(BigInteger x) {
//         return x.bitCount();
//     }

//     // Recursive build of sequences (repetition allowed, order matters)
//     // pos: current position in sequence [0..m)
//     // m: target length
//     // n: nums.length
//     // nums: input array
//     // curSum: BigInteger representing sum of 2^{seq[0]} + ... (so far)
//     // curProd: current product mod MOD of nums[seq[*]] (so far)
//     private void dfs(int pos, int m, int n, int k, int[] nums, BigInteger curSum, long curProd) {
//         if (pos == m) {
//             if (bitCount(curSum) == k) {
//                 result = (result + curProd) % MOD;
//             }
//             return;
//         }

//         // choose any index for this position
//         for (int i = 0; i < n; i++) {
//             // new sum = curSum + 2^i
//             BigInteger add = BigInteger.ONE.shiftLeft(i);
//             BigInteger nextSum = curSum.add(add);

//             // new product modulo
//             long nextProd = (curProd * (nums[i] % MOD)) % MOD;

//             dfs(pos + 1, m, n, k, nums, nextSum, nextProd);
//         }
//     }

//     public int magicalSum(int m, int k, int[] nums) {
//         result = 0L;
//         int n = nums.length;
//         dfs(0, m, n, k, nums, BigInteger.ZERO, 1L);
//         return (int) result;
//     }
// }






// import java.math.BigInteger;
// import java.util.*;

// class Solution {
//     long MOD = 1_000_000_007L;
//     long result = 0;
//     int n, m, k;
//     int[] nums;
//     long[] fact, invFact;

//     // Modular exponentiation
//     long modPow(long a, long b) {
//         long res = 1;
//         while (b > 0) {
//             if ((b & 1) == 1) res = (res * a) % MOD;
//             a = (a * a) % MOD;
//             b >>= 1;
//         }
//         return res;
//     }

//     // Precompute factorials for combinations
//     void precomputeFactorials(int limit) {
//         fact = new long[limit + 1];
//         invFact = new long[limit + 1];
//         fact[0] = 1;
//         for (int i = 1; i <= limit; i++) fact[i] = (fact[i - 1] * i) % MOD;
//         invFact[limit] = modPow(fact[limit], MOD - 2);
//         for (int i = limit - 1; i >= 0; i--)
//             invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
//     }

//     long nCr(int n, int r) {
//         if (r < 0 || r > n) return 0;
//         return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
//     }

//     void dfs(int idx, int remaining, long curProd, BigInteger curSum) {
//         if (idx == n) {
//             if (remaining == 0 && curSum.bitCount() == k) {
//                 result = (result + curProd) % MOD;
//             }
//             return;
//         }

//         BigInteger pow2 = BigInteger.ONE.shiftLeft(idx);

//         // Try all possible counts for this index
//         for (int count = 0; count <= remaining; count++) {
//             // ways = m choose count
//             long ways = nCr(remaining, count);
//             long powNum = modPow(nums[idx], count);
//             long newProd = (curProd * powNum) % MOD;
//             newProd = (newProd * ways) % MOD;

//             BigInteger newSum = curSum.add(pow2.multiply(BigInteger.valueOf(count)));
//             dfs(idx + 1, remaining - count, newProd, newSum);
//         }
//     }

//     public int magicalSum(int m, int k, int[] nums) {
//         this.nums = nums;
//         this.m = m;
//         this.k = k;
//         this.n = nums.length;
//         this.result = 0;

//         precomputeFactorials(m);
//         dfs(0, m, 1, BigInteger.ZERO);

//         return (int) result;
//     }
// }




// import java.math.BigInteger;
// import java.util.HashMap;
// import java.util.Map;

// class Solution {

//     final long MOD = 1_000_000_007L;
//     int n, m, k;
//     int[] nums;
//     long[] fact, invFact;
//     Map<String, Long> memo;

//     // modular exponent
//     private long modPow(long a, int e) {
//         long r = 1;
//         a %= MOD;
//         while (e > 0) {
//             if ((e & 1) == 1) r = (r * a) % MOD;
//             a = (a * a) % MOD;
//             e >>= 1;
//         }
//         return r;
//     }

//     // modular inverse using Fermat (MOD prime)
//     private long modInv(long x) {
//         return modPow((x % MOD + MOD) % MOD, (int)(MOD - 2));
//     }

//     private void prepareFactorials(int limit) {
//         fact = new long[limit + 1];
//         invFact = new long[limit + 1];
//         fact[0] = 1;
//         for (int i = 1; i <= limit; i++) fact[i] = (fact[i - 1] * i) % MOD;
//         invFact[limit] = modInv(fact[limit]);
//         for (int i = limit - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
//     }

//     private long nCr(int N, int R) {
//         if (R < 0 || R > N) return 0;
//         return (((fact[N] * invFact[R]) % MOD) * invFact[N - R]) % MOD;
//     }

//     /**
//      * dfs(idx, remaining, sum) returns the total contribution (mod MOD)
//      * from indices [idx..n-1] when we still must assign 'remaining' items,
//      * and current sum (BigInteger) is the accumulated sum of count_i * 2^i.
//      *
//      * At each idx we choose count in [0..remaining]. For chosen count:
//      *  - ways to place those count among remaining positions: nCr(remaining, count)
//      *  - multiplicative contribution from values: nums[idx]^count (mod MOD)
//      *  - new sum = sum + count * 2^idx (BigInteger)
//      *
//      * The base case returns 1 if remaining==0 and popcount(sum)==k, else 0.
//      */
//     private long dfs(int idx, int remaining, BigInteger sum) {
//         if (idx == n) {
//             // only valid if we've used exactly m items and sum has k set bits
//             if (remaining == 0 && sum.bitCount() == k) return 1L;
//             return 0L;
//         }

//         String key = idx + "," + remaining + "," + sum.toString();
//         if (memo.containsKey(key)) return memo.get(key);

//         long total = 0L;
//         BigInteger pow2 = BigInteger.ONE.shiftLeft(idx); // 2^idx

//         // try using `count` copies of index `idx`
//         for (int count = 0; count <= remaining; count++) {
//             long comb = nCr(remaining, count);               // number of ways to choose which positions assign to idx (multinomial piece)
//             long powNums = modPow(nums[idx], count);         // nums[idx]^count (mod)
//             BigInteger newSum = sum.add(pow2.multiply(BigInteger.valueOf(count)));

//             long sub = dfs(idx + 1, remaining - count, newSum);
//             if (sub != 0) {
//                 long add = (((comb % MOD) * powNums) % MOD) * sub % MOD;
//                 total += add;
//                 if (total >= MOD) total -= MOD;
//             }
//         }

//         memo.put(key, total);
//         return total;
//     }

//     public int magicalSum(int m, int k, int[] nums) {
//         this.n = nums.length;
//         this.m = m;
//         this.k = k;
//         this.nums = nums;
//         memo = new HashMap<>();

//         prepareFactorials(m); // factorials up to m (we only ever choose up to m copies in total)
//         long ans = dfs(0, m, BigInteger.ZERO);
//         return (int)(ans % MOD);
//     }

//     // optional main for quick local testing
//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int[] nums = {74166495,9431842,1408935,78143129,60095293,97777625,41460076,83818728,8312471,62584953,39015569,75735254,3302773,86824954,51336598,91087885,95326676,5568871,90380804,98903204,24240355,16525012,23205557,29806307,6002736,35355060,21038663,65010347,11443029,60291989,77446872,12332639,49741869,46233451,20574547,90452484,95124531,81368467,18808289,85748046,24811448,98203351,77131898,65131587,50176635,86509540,43894638,82182883,32539942,57687858};
//         System.out.println(s.magicalSum(3, 3, nums)); // compare to expected 522160529
//     }
// }


// import java.util.*;

// class Solution {

//     static final long MOD = 1_000_000_007L;

//     static int setBits(long num) {
//         return Long.bitCount(num);
//     }

//     static List<long[]> generate(int[] nums, int start, int end) {
//         int n = end - start;
//         List<long[]> list = new ArrayList<>();
//         int total = 1 << n;
//         for (int mask = 0; mask < total; mask++) {
//             long sumBits = 0;
//             long prod = 1;
//             int size = 0;
//             for (int i = 0; i < n; i++) {
//                 if ((mask & (1 << i)) != 0) {
//                     sumBits += (1L << (start + i));
//                     prod = (prod * nums[start + i]) % MOD;
//                     size++;
//                 }
//             }
//             list.add(new long[]{sumBits, prod, size});
//         }
//         return list;
//     }

//     public int magicalSum(int m, int k, int[] nums) {
//         int n = nums.length;
//         int mid = n / 2;

//         // Split into two halves
//         List<long[]> left = generate(nums, 0, mid);
//         List<long[]> right = generate(nums, mid, n);

//         // Group right half subsets by size
//         Map<Integer, List<long[]>> rightBySize = new HashMap<>();
//         for (long[] arr : right) {
//             rightBySize.computeIfAbsent((int) arr[2], x -> new ArrayList<>()).add(arr);
//         }

//         long result = 0;

//         for (long[] L : left) {
//             int sizeL = (int) L[2];
//             if (sizeL > m) continue;
//             int need = m - sizeL;
//             if (!rightBySize.containsKey(need)) continue;

//             for (long[] R : rightBySize.get(need)) {
//                 long totalSumBits = L[0] + R[0];
//                 if (setBits(totalSumBits) == k) {
//                     long val = (L[1] * R[1]) % MOD;
//                     result = (result + val) % MOD;
//                 }
//             }
//         }

//         return (int) result;
//     }
// }



class Solution {

    public long quickmul(long x, long y, long mod) {
        long res = 1;
        long cur = x % mod;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * cur) % mod;
            }
            y >>= 1;
            cur = (cur * cur) % mod;
        }
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        long mod = 1000000007;
        long[] fac = new long[m + 1];
        fac[0] = 1;
        for (int i = 1; i <= m; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }
        long[] ifac = new long[m + 1];
        ifac[0] = 1;
        ifac[1] = 1;
        for (int i = 2; i <= m; i++) {
            ifac[i] = quickmul(i, mod - 2, mod);
        }
        for (int i = 2; i <= m; i++) {
            ifac[i] = (ifac[i - 1] * ifac[i]) % mod;
        }
        long[][] numsPower = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            numsPower[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                numsPower[i][j] = (numsPower[i][j - 1] * nums[i]) % mod;
            }
        }
        long[][][][] f = new long[n][m + 1][m * 2 + 1][k + 1];
        for (int j = 0; j <= m; j++) {
            f[0][j][j][0] = (numsPower[0][j] * ifac[j]) % mod;
        }
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int p = 0; p <= m * 2; p++) {
                    for (int q = 0; q <= k; q++) {
                        int q2 = (p % 2) + q;
                        if (q2 > k) {
                            break;
                        }
                        for (int r = 0; r + j <= m; r++) {
                            int p2 = p / 2 + r;
                            f[i + 1][j + r][p2][q2] +=
                                (((f[i][j][p][q] * numsPower[i + 1][r]) % mod) *
                                    ifac[r]) %
                                mod;
                            f[i + 1][j + r][p2][q2] %= mod;
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int p = 0; p <= m * 2; p++) {
            for (int q = 0; q <= k; q++) {
                if (Integer.bitCount(p) + q == k) {
                    res = (res + ((f[n - 1][m][p][q] * fac[m]) % mod)) % mod;
                }
            }
        }
        return (int) res;
    }
}