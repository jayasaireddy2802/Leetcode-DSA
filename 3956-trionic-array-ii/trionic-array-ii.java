// class Solution {
//     int maxSum = Integer.MIN_VALUE;

//     public long solve(int idx, int[] nums, int trend) {
//         int len = nums.length;

//         if (idx >= len) {
//             return Long.MIN_VALUE / 2;
//         }

//         long skip = Long.MIN_VALUE / 2;
//         long take = Long.MIN_VALUE / 2;

//         if(trend == 0)
//         {
//             skip = solve(idx + 1, nums, trend);
//         }

//         if(trend == 3)
//         {
//             take = nums[idx];
//         }

//         if (idx + 1 < len) {
//             int curr = nums[idx];
//             int next = nums[idx + 1];

//             if (trend == 0 && next > curr)
//                 take = Math.max(take, curr + solve(idx + 1, nums, trend + 1));

//             else if (trend == 1) {
//                 if (next > curr)
//                     take = Math.max(take, curr + solve(idx + 1, nums, trend));
//                 if (next < curr)
//                     take = Math.max(take, curr + solve(idx + 1, nums, trend + 1));
//             }

//             else if (trend == 2) {
//                 if (next < curr)
//                     take = Math.max(take, curr + solve(idx + 1, nums, trend));
//                 if (next > curr)
//                     take = Math.max(take, curr + solve(idx + 1, nums, trend + 1));
//             }

//             else if (trend == 3) {
//                 if (next > curr) {
//                     take = Math.max(take, curr + solve(idx + 1, nums, trend));
//                 }
//             }


//         }
//             return Math.max(skip, take);

//     }

//     public long maxSumTrionic(int[] nums) {
//         return solve(0, nums, 0);
    
//     }
// }

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public long solve(int idx, int[] nums, int trend, long[][] dp) {
        int len = nums.length;

        if (idx >= len) {
            return Long.MIN_VALUE / 2;
        }

        if(dp[idx][trend] != Long.MIN_VALUE)
            return dp[idx][trend];

        long skip = Long.MIN_VALUE / 2;
        long take = Long.MIN_VALUE / 2;

        if(trend == 0)
        {
            skip = solve(idx + 1, nums, trend, dp);
        }

        if(trend == 3)
        {
            take = nums[idx];
        }

        if (idx + 1 < len) {
            int curr = nums[idx];
            int next = nums[idx + 1];

            if (trend == 0 && next > curr)
                take = Math.max(take, curr + solve(idx + 1, nums, trend + 1, dp));

            else if (trend == 1) {
                if (next > curr)
                    take = Math.max(take, curr + solve(idx + 1, nums, trend, dp));
                if (next < curr)
                    take = Math.max(take, curr + solve(idx + 1, nums, trend + 1, dp));
            }

            else if (trend == 2) {
                if (next < curr)
                    take = Math.max(take, curr + solve(idx + 1, nums, trend, dp));
                if (next > curr)
                    take = Math.max(take, curr + solve(idx + 1, nums, trend + 1, dp));
            }

            else if (trend == 3) {
                if (next > curr) {
                    take = Math.max(take, curr + solve(idx + 1, nums, trend, dp));
                }
            }


        }
            return dp[idx][trend] = Math.max(skip, take);

    }

    public long maxSumTrionic(int[] nums) {
        long[][] dp = new long[nums.length][4];

        for(long[] arr : dp)
            Arrays.fill(arr, Long.MIN_VALUE);
        return solve(0, nums, 0, dp);
    
    }
}
