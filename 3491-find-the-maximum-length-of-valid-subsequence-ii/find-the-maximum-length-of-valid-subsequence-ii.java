// class Solution {

//     int maxi = 0;

//     public void solve(int idx, int prev, int[] nums, int k, int count, int val)
//     {
//         if(idx == nums.length)
//         {
//             maxi = Math.max(count, maxi);
//             return ;
//         }

//         if(prev == -1 || ((nums[idx] + prev) % k == val))
//             solve(idx + 1, nums[idx], nums, k, count + 1, val);
//         solve(idx + 1, prev, nums, k, count, val);
//     }

//     public int maximumLength(int[] nums, int k) {

//         for(int i = 0; i < k; i++)
//         {
//             solve(0, -1, nums, k, 0, i);
//         }
//         return maxi;
        
//     }
// }


// class Solution {

//     int maxi = 0;

//     public void solve(int idx, int prevIdx, int[] nums, int k, int count, int val, int[][] dp)
//     {
//         if(idx == nums.length)
//         {
//             maxi = Math.max(count, maxi);
//             return ;
//         }

//         if(prevIdx != -1 && dp[idx][prevIdx + 1] != -1)
//         {
//             maxi = Math.max(maxi, dp[idx][prevIdx]);
//             return ;
//         }

//         if(prevIdx == -1 || ((nums[idx] + nums[prevIdx]) % k == val))
//             solve(idx + 1, idx, nums, k, count + 1, val, dp);
//         solve(idx + 1, prevIdx, nums, k, count, val, dp);

//         dp[idx][prevIdx + 1] = maxi;

//     }

//     public int maximumLength(int[] nums, int k) {
//         int len = nums.length;

//         for(int i = 0; i < k; i++)
//         {
//             int[][] dp = new int[len][len + 1];
//             for(int[] arr : dp)
//                 Arrays.fill(arr, -1);
//             solve(0, -1, nums, k, 0, i, dp);
//         }
//         return maxi;
        
//     }
// }

 class Solution {
    public int maximumLength(int[] nums, int k) {

        int len = nums.length;
        int maxi = 0;
        int dp[][] = new int[k][len];

        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                int mod = (nums[i] + nums[j]) % k;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxi = Math.max(dp[mod][i], maxi);
            }
        }

        return ++maxi;

    }
 }
