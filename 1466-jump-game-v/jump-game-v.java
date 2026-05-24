// class Solution {

//     public int solve(int idx, int[] arr, int d)
//     {
//         int res = 1;
//         int len = arr.length;
//         int left = Math.max(0, idx - d);
//         int right = Math.min(len - 1, idx + d);

//         for(int i = idx - 1; i >= left; i--)
//         {
//             if(arr[i] >= arr[idx]) 
//                 break;

//             res = Math.max(res, 1 + solve(i, arr, d));
//         }

//         for(int i = idx + 1; i <= right; i++)
//         {
//             if(arr[i] >= arr[idx])
//                 break;

//             res = Math.max(res, 1 + solve(i, arr, d));
//         }

//         return res;

//     }

//     public int maxJumps(int[] arr, int d) {
//         int len = arr.length;
//         int ans = 1;

//         for(int i = 0; i < len; i++)
//         {
//             ans = Math.max(ans, solve(i, arr, d));
//         }

//         return ans;
//     }
// }



class Solution {

    public int solve(int idx, int[] arr, int d, int[] dp)
    {
        int res = 1;
        int len = arr.length;
        int left = Math.max(0, idx - d);
        int right = Math.min(len - 1, idx + d);

        if(dp[idx] != -1)
            return dp[idx];

        for(int i = idx - 1; i >= left; i--)
        {
            if(arr[i] >= arr[idx]) 
                break;

            res = Math.max(res, 1 + solve(i, arr, d, dp));
        }

        for(int i = idx + 1; i <= right; i++)
        {
            if(arr[i] >= arr[idx])
                break;

            res = Math.max(res, 1 + solve(i, arr, d, dp));
        }

        return dp[idx] = res;

    }

    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        int ans = 1;
        int[] dp = new int[len];

        Arrays.fill(dp, -1);


        for(int i = 0; i < len; i++)
        {
            ans = Math.max(ans, solve(i, arr, d, dp));
        }

        return ans;
    }
}