// class Solution {

//     public boolean solve(int n)
//     {
//         if(n == 0)  return false;

//         for(int k = 1; k * k <= n; k++)
//         {
//             if(solve(n - (k * k)) == false)
//                 return true;
//         }

//         return false;
//     }
//     public boolean winnerSquareGame(int n) {
//         return solve(n);
//     }
// }

// class Solution {

//     public boolean solve(int n, Map<Integer, Boolean> map)
//     {
//         if(n == 0)  return false;

//         if(map.containsKey(n))
//             return map.get(n);

//         for(int k = 1; k * k <= n; k++)
//         {
//             if(solve(n - (k * k), map) == false)
//                 return true;
//         }

//         map.put(n, false);
//         return false;
//     }
//     public boolean winnerSquareGame(int n) {
//         Map<Integer, Boolean> map = new HashMap<>();

//         return solve(n, map);
//     }
// }

class Solution {
    public boolean solve(int n, Boolean[] dp) {
        if (n == 0) return false;

        if (dp[n] != null) return dp[n];

        for (int k = 1; k * k <= n; k++) {
            if (!solve(n - k * k, dp)) {
                return dp[n] = true; 
            }
        }

        return dp[n] = false;
    }

    public boolean winnerSquareGame(int n) {
        return solve(n, new Boolean[n + 1]);
    }
}