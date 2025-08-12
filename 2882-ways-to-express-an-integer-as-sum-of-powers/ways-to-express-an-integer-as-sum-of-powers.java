// class Solution {

//     int mod = 1000000007;

//     public int totalWays(int num, int n, int x, int currSum)
//     {
//         if(currSum > n || num > n)
//         {
//             return (currSum == n) ? 1 : 0; 
//         }

//         int l = totalWays(num + 1, n, x, currSum);
//         int r = totalWays(num + 1, n, x, (currSum + (int)Math.pow(num, x)));

//         return (l%mod + r%mod)%mod;
//     }

//     public int numberOfWays(int n, int x) {
//         return totalWays(1, n, x, 0);
//     }
// }

class Solution {

    int mod = 1000000007;

    public int totalWays(int num, int n, int x, int currSum, int[][] dp)
    {
        if(currSum >= n || num > n)
        {
            return (currSum == n) ? 1 : 0; 
        }

        if(dp[num][currSum] != -1)
            return dp[num][currSum];
        
        int l = totalWays(num + 1, n, x, currSum, dp);

        long val = (long)Math.pow(num, x);
        int r = 0;
        if(currSum + val <= n)
            r = totalWays(num + 1, n, x, currSum + (int)val, dp);

        return dp[num][currSum] = (l%mod + r%mod)%mod;
    }

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n + 10][n + 10];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        return totalWays(1, n, x, 0, dp);
    }
}