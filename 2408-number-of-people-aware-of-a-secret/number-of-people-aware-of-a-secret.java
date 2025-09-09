class Solution {
    int mod = 1000000007;
    int[] dp;
    public int solve(int n, int delay, int forget)
    {
        if(n == 1)
            return 1;
        if(n == 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];

        long result = 0;
        for(int d = n-forget+1; d <= n - delay; d++)
        {
            if(d > 0)
                result = (result + solve(d, delay, forget)) % mod;
        }
        return dp[n] = (int)result;
    }
    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int result = 0;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        for(int d = n-forget+1; d <= n; d++)
        {
            if(d > 0)
                result = (result + solve(d, delay, forget)) % mod;
        }

        return result;
    }
}