// class Solution {

//     int maxi = 0;

//     public void solve(int i, int j, int total, int[] stoneValue, int[] prefix)
//     {
//         if(i >= j)
//         {
//             maxi = Math.max(maxi, total);
//             return;
//         }

//         for(int idx = i; idx < j; idx++)
//         {
//             int leftSum  = prefix[idx + 1] - prefix[i];
//             int rightSum = prefix[j + 1] - prefix[idx + 1];

//             if(leftSum < rightSum)
//             {
//                 solve(i, idx, total + leftSum, stoneValue, prefix);
//             }
//             else if(leftSum > rightSum)
//             {
//                 solve(idx + 1, j, total + rightSum, stoneValue, prefix);
//             }
//             else
//             {
//                 solve(i, idx,     total + leftSum,  stoneValue, prefix);
//                 solve(idx + 1, j, total + rightSum, stoneValue, prefix);
//             }
//         }
//     }

//     public int stoneGameV(int[] stoneValue) {

//         int n = stoneValue.length;
//         int[] prefix = new int[n + 1];

//         for(int i = 0; i < n; i++)
//         {
//             prefix[i + 1] = prefix[i] + stoneValue[i];
//         }

//         solve(0, n - 1, 0, stoneValue, prefix);

//         return maxi;
//     }
// }
class Solution {

    int[][] memo;

    public int solve(int i, int j, int[] prefix) {
        if (i >= j) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int result = 0;

        for (int idx = i; idx < j; idx++) {
            int leftSum  = prefix[idx + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[idx + 1];

            if (leftSum < rightSum) {
                result = Math.max(result, leftSum  + solve(i, idx, prefix));
            } else if (leftSum > rightSum) {
                result = Math.max(result, rightSum + solve(idx + 1, j, prefix));
            } else {
                // Equal: try both sides
                result = Math.max(result,
                    leftSum  + solve(i, idx, prefix));
                result = Math.max(result,
                    rightSum + solve(idx + 1, j, prefix));
            }
        }

        return memo[i][j] = result;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        memo = new int[n][n];
        for (int[] row : memo) java.util.Arrays.fill(row, -1);

        return solve(0, n - 1, prefix);
    }
}