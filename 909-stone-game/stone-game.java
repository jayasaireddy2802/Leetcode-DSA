// class Solution {

//     public int solve(int i, int j, int[] piles) 
//     {
//         if(i > j)
//             return 0;

//         int take_i = piles[i] + Math.min(solve(i + 2, j, piles), solve(i + 1, j - 1, piles));

//         int take_j = piles[j] + Math.min(solve(i, j - 2, piles), solve(i + 1, j - 1, piles));

//         return Math.max(take_i, take_j);
//     }

//     public boolean stoneGame(int[] piles) {

//         int sum = 0;

//         for(int pile : piles)
//             sum += pile;
        
//         int val = solve(0, piles.length - 1, piles);

//         return val >= (sum - val); 
//     }
// }

class Solution {

    public int solve(int i, int j, int[] piles, int[][] dp) 
    {
        if(i > j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int take_i = piles[i] + Math.min(solve(i + 2, j, piles, dp), solve(i + 1, j - 1, piles, dp));

        int take_j = piles[j] + Math.min(solve(i, j - 2, piles, dp), solve(i + 1, j - 1, piles, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }

    public boolean stoneGame(int[] piles) {

        int sum = 0;

        for(int pile : piles)
            sum += pile;

        int[][] dp = new int[piles.length][piles.length];

        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        int val = solve(0, piles.length - 1, piles, dp);

        return val >= (sum - val); 
    }
}