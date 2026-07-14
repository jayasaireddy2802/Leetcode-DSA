// class Solution {

//     int mod = 1000000007;
    
//     public int gcd(int a, int b)
//     {
//         if(b == 0)
//             return a;

//         return gcd(b, a % b);
//     }

//     public int solve(int idx, int first, int second, int[] nums)
//     {
//         int len = nums.length;

//         if(idx == len)
//         {
//             if (first == 0 && second == 0) return 0;
//             return (first == second) ? 1 : 0;
//         }

//         int ct = 0;

//         int nottake = solve(idx + 1, first, second, nums);
//         int seq1 = solve(idx + 1, gcd(first, nums[idx]), second, nums);
//         int seq2 = solve(idx + 1, first, gcd(second, nums[idx]), nums);

//         return (nottake + seq1 + seq2) % mod;
//     }

//     public int subsequencePairCount(int[] nums) {
//         int ans = solve(0, 0, 0, nums);
//         return ans;
//     }
// }


// import java.util.*;

// class Solution {

//     int mod = 1000000007;
//     Map<String, Integer> memo = new HashMap<>();

//     public int gcd(int a, int b) {
//         if (b == 0)
//             return a;
//         return gcd(b, a % b);
//     }

//     public int solve(int idx, int first, int second, int[] nums) {
//         int len = nums.length;

//         if (idx == len) {
//             if (first == 0 && second == 0) return 0; // exclude empty
//             return (first == second) ? 1 : 0;
//         }

//         String key = idx + "," + first + "," + second;
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         int nottake = solve(idx + 1, first, second, nums);
//         int seq1 = solve(idx + 1, gcd(first, nums[idx]), second, nums);
//         int seq2 = solve(idx + 1, first, gcd(second, nums[idx]), nums);

//         int ans = (int)(((long)nottake + seq1 + seq2) % mod);
//         memo.put(key, ans);
//         return ans;
//     }

//     public int subsequencePairCount(int[] nums) {
//         return solve(0, 0, 0, nums);
//     }
// }

import java.util.*;

class Solution {

    int mod = 1000000007;
    int[][][] dp;

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int solve(int idx, int first, int second, int[] nums) {
        int len = nums.length;

        if (idx == len) {
            if (first == 0 && second == 0) return 0; 
            return (first == second) ? 1 : 0;
        }

        if (dp[idx][first][second] != -1) {
            return dp[idx][first][second];
        }

        int nottake = solve(idx + 1, first, second, nums);
        int seq1 = solve(idx + 1, gcd(first, nums[idx]), second, nums);
        int seq2 = solve(idx + 1, first, gcd(second, nums[idx]), nums);

        return dp[idx][first][second] =
                (int)(((long)nottake + seq1 + seq2) % mod);
    }

    public int subsequencePairCount(int[] nums) {

        int n = nums.length;

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        dp = new int[n][maxVal + 1][maxVal + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, nums);
    }
}