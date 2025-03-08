// class Solution {

//     public int solve(int idx, String blocks, int k, int whitecount, int k1)
//     {
//         if(k == 0)
//             return whitecount;
//         if(idx == blocks.length())
//             return (int)1e6;
       
//         int take = solve(idx + 1, blocks, k - 1, whitecount + ((blocks.charAt(idx) == 'W') ? 1 : 0 ), k1);
//         int nottake = solve(idx + 1, blocks, k1, 0, k1);
//         return Math.min(take, nottake);
//     }
//     public int minimumRecolors(String blocks, int k) {
//         return solve(0, blocks, k, 0, k);
//     }
// }

class Solution {
    int[][][] dp;

    public int solve(int idx, String blocks, int k, int whitecount, int k1)
    {
        if(k == 0)
            return whitecount;
        if(idx == blocks.length())
            return (int)1e6;
        if(dp[idx][k][whitecount] != -1)
            return dp[idx][k][whitecount];

        int take = solve(idx + 1, blocks, k - 1, whitecount + ((blocks.charAt(idx) == 'W') ? 1 : 0 ), k1);
        int nottake = solve(idx + 1, blocks, k1, 0, k1);
        return dp[idx][k][whitecount] = Math.min(take, nottake);
    }
    public int minimumRecolors(String blocks, int k) {
        dp = new int[105][105][105];
        
            for(int[][] arr2 : dp)
            {
                for(int[] arr3 : arr2)
                    Arrays.fill(arr3, -1);
            }
        return solve(0, blocks, k, 0, k);
    }
}