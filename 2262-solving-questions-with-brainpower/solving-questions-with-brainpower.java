// class Solution {

//     public long solve(int idx, int[][] questions)
//     {
//         if(idx >= questions.length)
//             return 0;

//         long take = questions[idx][0] + solve(idx + questions[idx][1] + 1, questions);
//         long nottake = 0 + solve(idx + 1, questions);

//         return Math.max(take, nottake);
//     }
//     public long mostPoints(int[][] questions) {

//         return solve(0, questions);        
//     }
// }


class Solution {

    public long solve(int idx, int[][] questions, long[] dp)
    {
        if(idx >= questions.length)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        long take = questions[idx][0] + solve(idx + questions[idx][1] + 1, questions, dp);
        long nottake = 0 + solve(idx + 1, questions, dp);

        return dp[idx] = Math.max(take, nottake);
    }
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);        
    }
}

 