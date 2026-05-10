// class Solution {

//     public int solve(int idx, int[] nums, int target)
//     {
//         int len = nums.length;

//         if(idx == len - 1) 
//             return 0;
        
//         if(idx >= len)
//             return -5000;

//         int ans = -5000;

//         for(int i = idx + 1; i < len; i++)
//         {
//             if(Math.abs(nums[idx] - nums[i]) <= target)
//             {
//                 int temp = solve(i, nums, target);
//                 if(temp != -5000)
//                     ans = Math.max(temp + 1, ans);
//             }
//         }

//         return ans;
//     }

//     public int maximumJumps(int[] nums, int target) {
        
//         int res = solve(0, nums, target);
//         return (res == -5000) ? -1 : res;

//     }
// }



class Solution {

    public int solve(int idx, int[] nums, int target, int[] dp)
    {
        int len = nums.length;

        if(idx == len - 1) 
            return 0;
        
        if(idx >= len)
            return -5000;

        if(dp[idx] != -1)
            return dp[idx];

        int ans = -5000;

        for(int i = idx + 1; i < len; i++)
        {
            if(Math.abs(nums[idx] - nums[i]) <= target)
            {
                int temp = solve(i, nums, target, dp);
                if(temp != -5000)
                    ans = Math.max(temp + 1, ans);
            }
        }

        return dp[idx] = ans;
    }

    public int maximumJumps(int[] nums, int target) {
        
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);
        int res = solve(0, nums, target, dp);
        return (res == -5000) ? -1 : res;

    }
}