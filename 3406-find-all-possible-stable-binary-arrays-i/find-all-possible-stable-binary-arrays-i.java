// class Solution {

//     int mod = 1000000007;

//     public int solve(int zero, int one, int limit, boolean isLastWasOne)
//     {
//         if(zero == 0 && one == 0)
//             return 1;
        
//         int result = 0;
//         if(isLastWasOne)
//         {
//             int len = Math.min(zero, limit);
//             for(int i = 1; i <= len; i++)
//             {
//                 result = (result + solve(zero - i, one, limit, false)) % mod;
//             }
//         }
//         else
//         {
//             int len = Math.min(one, limit);
//             for(int i = 1; i <= len; i++)
//             {
//                 rresult = (result + solve(zero, one - i, limit, true)) % mod;
//             }
//         }

//         return result;
//     }

//     public int numberOfStableArrays(int zero, int one, int limit) {
//         int startWithZero = solve(zero, one, limit, true);
//         int startWithOne = solve(zero, one, limit, false);
//         return (startWithZero + startWithOne) % mod;
//     }
// }


class Solution {

    int mod = 1000000007;

    public int solve(int zero, int one, int limit, boolean isLastWasOne, int[][][] dp)
    {
        if(zero == 0 && one == 0)
            return 1;

        int isOne = isLastWasOne == true ? 1 : 0;

        if(dp[zero][one][isOne] != -1)
            return dp[zero][one][isOne];
        
        int result = 0;
        if(isLastWasOne)
        {
            int len = Math.min(zero, limit);
            for(int i = 1; i <= len; i++)
            {
                result = (result + solve(zero - i, one, limit, false, dp)) % mod;
            }
        }
        else
        {
            int len = Math.min(one, limit);
            for(int i = 1; i <= len; i++)
            {
                result = (result + solve(zero, one - i, limit, true, dp)) % mod;
            }
        }

        return dp[zero][one][isOne] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[201][201][2];

        for(int[][] arr1 : dp)
        {
            for(int[] arr2 : arr1)
                Arrays.fill(arr2, -1);
        }
        int startWithZero = solve(zero, one, limit, true, dp);
        int startWithOne = solve(zero, one, limit, false, dp);
        return (startWithZero + startWithOne) % mod;
    }
}