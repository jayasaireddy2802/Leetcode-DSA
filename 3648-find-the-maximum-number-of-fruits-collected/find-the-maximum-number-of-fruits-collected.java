// class Solution {

//     public static final int min = Integer.MIN_VALUE;

//     private int childTwoFruits(int i, int j, int moves, int n, int[][] fruits)
//     {
//         if(i < 0 || i >= n || j >= n || j < 0 || moves < 0)
//             return min;

//         if(i == n - 1 && j == n - 1)
//         {
//             return (moves == 0) ? 0 : min;
//         }
        
//         if(moves < 0)
//             return min;      

//         int fruit = fruits[i][j];
//         fruits[i][j] = 0;

//         int ans1 = childTwoFruits(i + 1, j - 1, moves - 1, n, fruits);
//         int ans2 = childTwoFruits(i + 1, j , moves - 1, n, fruits);
//         int ans3 = childTwoFruits(i + 1, j + 1, moves - 1, n, fruits);

//         int val = Math.max(ans1, Math.max(ans2, ans3));
//         fruits[i][j] = fruit; 

//         if(val < 0)
//             return min;

//         return val + fruits[i][j];
//     }


//     private int childThreeFruits(int i, int j, int moves, int n, int[][] fruits)
//     {
//         if(i < 0 || i >= n || j >= n || j < 0 || moves < 0)
//             return min;

//         if(i == n - 1 && j == n - 1)
//         {
//             return (moves == 0) ? 0 : min;
//         }
        
//         if(moves < 0)
//             return min;       

//         int fruit = fruits[i][j];
//         fruits[i][j] = 0; 

//         int ans1 = childThreeFruits(i - 1, j + 1, moves - 1, n, fruits);
//         int ans2 = childThreeFruits(i , j + 1 , moves - 1, n, fruits);
//         int ans3 = childThreeFruits(i + 1, j + 1, moves - 1, n, fruits);

//         int val = Math.max(ans1, Math.max(ans2, ans3));
//         fruits[i][j] = fruit;
//         if(val < 0)
//             return min;

//         return val + fruits[i][j];
//     }

//     public int maxCollectedFruits(int[][] fruits) {
//         int n = fruits.length;
      

//         int childOneFruits = 0;
//         for(int i = 0; i < n; i++)
//         {
//             childOneFruits += fruits[i][i];
//             fruits[i][i] = 0;
//         }

//         int res1 = childTwoFruits(0, n - 1, n - 1, n, fruits);
        
//         int res2 = childThreeFruits(n - 1, 0, n - 1, n, fruits);

//         return childOneFruits + res1 + res2;

//     }
// }



class Solution {

    public static final int min = Integer.MIN_VALUE;

    private int childTwoFruits(int i, int j, int moves, int n, int[][] fruits, int[][] dp)
    {
        if(i < 0 || i >= n || j >= n || j < 0 || moves < 0)
            return min;

        if(i == n - 1 && j == n - 1)
        {
            return (moves == 0) ? 0 : min;
        }
        
        if(moves < 0)
            return min;      

        if(dp[i][j] != -1)
            return dp[i][j];

        int fruit = fruits[i][j];
        fruits[i][j] = 0;

        int ans1 = childTwoFruits(i + 1, j - 1, moves - 1, n, fruits, dp);
        int ans2 = childTwoFruits(i + 1, j , moves - 1, n, fruits, dp);
        int ans3 = childTwoFruits(i + 1, j + 1, moves - 1, n, fruits, dp);

        int val = Math.max(ans1, Math.max(ans2, ans3));
        fruits[i][j] = fruit; 

        if(val < 0)
            return dp[i][j] = min;

        return dp[i][j] = val + fruits[i][j];
    }


    private int childThreeFruits(int i, int j, int moves, int n, int[][] fruits, int[][] dp)
    {
        if(i < 0 || i >= n || j >= n || j < 0 || moves < 0)
            return min;

        if(i == n - 1 && j == n - 1)
        {
            return (moves == 0) ? 0 : min;
        }
        
        if(moves < 0)
            return min;  

        if(dp[i][j] != -1)
            return dp[i][j];

        int fruit = fruits[i][j];
        fruits[i][j] = 0; 

        int ans1 = childThreeFruits(i - 1, j + 1, moves - 1, n, fruits, dp);
        int ans2 = childThreeFruits(i , j + 1 , moves - 1, n, fruits, dp);
        int ans3 = childThreeFruits(i + 1, j + 1, moves - 1, n, fruits, dp);

        int val = Math.max(ans1, Math.max(ans2, ans3));
        fruits[i][j] = fruit;
        if(val < 0)
            return dp[i][j] = min;

        return dp[i][j] = val + fruits[i][j];
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
      

        int childOneFruits = 0;
        for(int i = 0; i < n; i++)
        {
            childOneFruits += fruits[i][i];
            fruits[i][i] = 0;
        }

        int[][] dp = new int[n][n];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        int res1 = childTwoFruits(0, n - 1, n - 1, n, fruits, dp);
        
        dp = new int[n][n];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        int res2 = childThreeFruits(n - 1, 0, n - 1, n, fruits, dp);

        return childOneFruits + res1 + res2;

    }
}

