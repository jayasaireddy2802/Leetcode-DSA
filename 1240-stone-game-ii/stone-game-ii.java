// class Solution {

//     public int solve(int idx, int len, boolean isAlice, int[] piles, int m)
//     {
//         if(idx >= len)
//             return 0;

//         int res = (isAlice == true) ? -1 : Integer.MAX_VALUE;
//         int size = Math.min(2 * m, len - idx);
//         int stones = 0;

//         for(int x = 1; x <= size; x++)
//         {
//             stones += piles[idx + x - 1];

//             if(isAlice)
//                 res = Math.max(res, stones + solve(idx + x, len, !isAlice, piles, Math.max(m, x)));
//             else
//                 res = Math.min(res, solve(idx + x, len, !isAlice, piles, Math.max(m, x)));
//         }

//         return res;
//     }

//     public int stoneGameII(int[] piles) {

//         int len = piles.length;

//         return solve(0, len, true, piles, 1);
        
//     }
// }


class Solution {

    public int solve(int idx, int len, int isAlice, int[] piles, int m, int[][][] dp)
    {
        if(idx >= len)
            return 0;

        int res = (isAlice == 0) ? -1 : Integer.MAX_VALUE;
        int size = Math.min(2 * m, len - idx);
        int stones = 0;

        if(dp[idx][m][isAlice] != -1)
            return dp[idx][m][isAlice];

        for(int x = 1; x <= size; x++)
        {
            stones += piles[idx + x - 1];

            if(isAlice == 0)
                res = Math.max(res, stones + solve(idx + x, len, 1, piles, Math.max(m, x), dp));
            else
                res = Math.min(res, solve(idx + x, len, 0, piles, Math.max(m, x), dp));
        }

        return dp[idx][m][isAlice] = res;
    }

    public int stoneGameII(int[] piles) {

        int len = piles.length;
        int[][][] dp = new int[len][len + 1][2];

        for(int[][] arr : dp)
        {
            for(int[] arr1 : arr)
                Arrays.fill(arr1, -1);
        }

        return solve(0, len, 0, piles, 1, dp);
        
    }
}