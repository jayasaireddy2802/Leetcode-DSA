// class Solution {
//     public double findProbability(int a, int b, int[][] serves)
//     {
//         if(a <= 0 && b <= 0)
//             return 0.5;
//         if(a <= 0)
//             return 1;
//         if(b <= 0)
//             return 0;
        
//         double probability = 0;

//         for(int[] serve : serves)
//         {
//             probability += findProbability(a - serve[0], b - serve[1], serves);
//         }

//         return 0.25*probability;
//     }

//     public double soupServings(int n) {
//         int[][] serves = new int[4][4];
//         serves[0][0] = 100;
//         serves[0][1] = 0;
//         serves[1][0] = 75;
//         serves[1][1] = 25;
//         serves[2][0] = 50;
//         serves[2][1] = 50;
//         serves[3][0] = 25;
//         serves[3][1] = 75;
//         return findProbability(n, n, serves);
//     }
// }

// class Solution {
//     public double findProbability(int a, int b, int[][] serves, double[][] dp)
//     {
//         if(a <= 0 && b <= 0)
//             return 0.5;
//         if(a <= 0)
//             return 1;
//         if(b <= 0)
//             return 0;

//         if(dp[a][b] != -1)
//             return dp[a][b];
        
//         double probability = 0;

//         for(int[] serve : serves)
//         {
//             probability += findProbability(a - serve[0], b - serve[1], serves, dp);
//         }

//         return dp[a][b] = 0.25*probability;
//     }

//     public double soupServings(int n) {

//         int[][] serves = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
//         double[][] dp = new double[n+1][n+1];
//         for(double[] arr : dp)
//             Arrays.fill(arr, -1);

//         return findProbability(n, n, serves, dp);
//     }
// }


class Solution {
    public double findProbability(int a, int b, int[][] serves, double[][] dp)
    {
        if(a <= 0 && b <= 0)
            return 0.5;
        if(a <= 0)
            return 1;
        if(b <= 0)
            return 0;

        if(dp[a][b] != -1)
            return dp[a][b];
        
        double probability = 0;

        for(int[] serve : serves)
        {
            probability += findProbability(a - serve[0], b - serve[1], serves, dp);
        }

        return dp[a][b] = 0.25*probability;
    }

    public double soupServings(int n) {
        if(n > 5000)
            return 1;
        int[][] serves = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
        double[][] dp = new double[n+1][n+1];
        for(double[] arr : dp)
            Arrays.fill(arr, -1);

        return findProbability(n, n, serves, dp);
    }
}