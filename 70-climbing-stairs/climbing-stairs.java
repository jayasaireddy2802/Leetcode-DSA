// class Solution {
//     public int climbStairs(int n283) {
    //   if (n283 == 0 || n283 == 1) {
    //         return 1;
    //     }
    //     int prev = 1, curr = 1;
    //     for (int i = 2; i <= n283; i++) {
    //         int temp = curr;
    //         curr = prev + curr;
    //         prev = temp;
    //     }
    //     return curr;
    // if(n283 == 0 || n283 == 1)
    //     return 1;
    // int l = climbStairs(n283 - 1);
    // int r = climbStairs(n283 - 2);
    // return l + r;   

//     }
// }


// brute force
// class Solution {

//     public int solve(int n)
//     {
//         if(n == 0 || n == 1)
//             return 1;
        
//         int left = solve(n-1);
//         int right = solve(n-2);

//         return left + right;
//     }

//     public int climbStairs(int n) {
        
//         return solve(n);
//     }
// }



// class Solution {

//     public int solve(int n, int[] dp)
//     {
//         if(n == 0 || n == 1)
//             return 1;

//         if(dp[n] != -1)
//             return dp[n];

//         int left = solve(n-1, dp);
//         int right = solve(n-2, dp);

//         return dp[n] = left + right;
//     }

//     public int climbStairs(int n) {
        
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return solve(n, dp);
//     }
// }

 
class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

 