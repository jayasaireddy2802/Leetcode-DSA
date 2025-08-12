import java.util.*;

class Solution {
    int mod = 1000000007;

    private int[] powersOfTwo(int n) {
        List<Integer> list = new ArrayList<>();
        String binary = Integer.toString(n, 2);
        int len = binary.length();
        int ct = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1')
                list.add(1 << ct);
            ct++;
        }

        int[] powers = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            powers[i] = list.get(i);
        }
        return powers;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public int[] productQueries(int n, int[][] queries) {
        int[] powers = powersOfTwo(n);
        int m = powers.length;

        long[] prefix = new long[m];
        prefix[0] = powers[0] % mod;
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powers[i]) % mod;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (x == 0) {
                ans[i] = (int) (prefix[y] % mod);
            } else {
                long inv = modPow(prefix[x - 1], mod - 2); // modular inverse
                ans[i] = (int) ((prefix[y] * inv) % mod);
            }
        }
        return ans;
    }
}




// class Solution {
//     int mod = 1000000007;

//     private int[] powersOfTwo(int n)
//     {
//         List<Integer> list = new ArrayList<>();

//         String binary = Integer.toString(n, 2);
//         int len = binary.length();
//         int ct = 0;

//         for(int i = len - 1; i >= 0; i--)
//         {
//             if(binary.charAt(i) == '1')
//                 list.add(1 << ct);
//             ct++;
//         }

//         len = list.size();
//         int powers[] = new int[len];
//         int i = 0;
//         for(int num : list)
//         {
//             powers[i] = num;
//             i++;
//         }

//         return powers;
//     }

//     private long modPow(long base, long exp) {
//         long result = 1;
//         while (exp > 0) {
//             if ((exp & 1) == 1) result = (result * base) % mod;
//             base = (base * base) % mod;
//             exp >>= 1;
//         }
//         return result;
//     }

//     public int[] productQueries(int n, int[][] queries) {
//         int len = queries.length;

//         int[] ans = new int[len];

//         int[] powers = powersOfTwo(n);

//         int j = 0;
//         for(int[] query : queries)
//         {
//             int x = query[0];
//             int y = query[1];
//             long product = 1;

//             for(int i = x; i <= y; i++)
//             {
//                 product = (product * powers[i]) % mod;
//             }

//             ans[j] = (int)product;
//             j++;
//         }

//         return ans;
//     }
// }