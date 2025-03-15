// class Solution {
//     int mini = Integer.MAX_VALUE;
//     int maxi;

//     public void solve(int idx, int k, int[] nums, int currMax)
//     {
//         if(k == 0)
//         {
//             mini = Math.min(mini, currMax);
//             return ;
//         }
        
//         if(idx >= nums.length)
//             return ;

        
//         solve(idx + 1, k, nums, currMax);
//         if(k > 0)
//         {
//             solve(idx+2, k-1, nums, Math.max(nums[idx], currMax));
//         }
//     }

//     public int minCapability(int[] nums, int k) {
//         solve(0, k, nums, 0);
//         return mini;
//     }
// }



// class Solution {
//     int mini = Integer.MAX_VALUE;
//     int maxi;

//     public int solve(int idx, int k, int[] nums)
//     {
//         if(k == 0)
//         {
//             return 0;
//         }
        
//         if(idx >= nums.length)
//             return Integer.MAX_VALUE;
        
//         int not_take = solve(idx + 1, k, nums);
//         int take = Integer.MAX_VALUE;
//         if(k > 0)
//         {
//             take = Math.max(nums[idx], solve(idx+2, k-1, nums));
//         }

//         return Math.min(not_take, take);
//     }

//     public int minCapability(int[] nums, int k) {
//         return solve(0, k, nums);
//     }
// }



// class Solution {
//     int mini = Integer.MAX_VALUE;
//     int maxi;

//     public int solve(int idx, int k, int[] nums, int[][] dp)
//     {
//         if(k == 0)
//         {
//             return 0;
//         }

//         if(idx >= nums.length)
//             return Integer.MAX_VALUE;

//         if(dp[idx][k] != -1)
//             return dp[idx][k];
        
//         int not_take = solve(idx + 1, k, nums, dp);
//         int take = Integer.MAX_VALUE;
//         if(k > 0)
//         {
//             take = Math.max(nums[idx], solve(idx+2, k-1, nums, dp));
//         }

//         return dp[idx][k] = Math.min(not_take, take);
//     }

//     public int minCapability(int[] nums, int k) {
//         int[][] dp = new int[nums.length][k+1];
//         for(int[] arr : dp)
//             Arrays.fill(arr, -1);
//         return solve(0, k, nums, dp);
//     }
// }


class Solution {

    public boolean isPossible(int mid, int[] nums, int k)
    {
        int houses = 0;
        int i = 0;
        int n = nums.length;
        while(i < n)
        {
            if(nums[i] <= mid)
            {
                houses++;
                i++;
            }
            i++;
        }

        return (houses >= k);
    }

    public int minCapability(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int num : nums)
        {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        int i = mini, j = maxi;

        while(i <= j)
        {
            int mid = (i + j)/2;
            if(isPossible(mid, nums, k))
            {
                j = mid - 1;
            }
            else
            {
                i = mid + 1; 
            }
        }

        return i;
    }
}