class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        
        int len = nums.length;
        long ct = 0;
        long ans = 0;
        long toBeSubtracted = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
        {
            long val = nums[i] ^ k;

            if(val > nums[i])
            {
                ans = ans + val;
                ct++;                
            }
            else
            {
                ans = ans + nums[i];
            }

            toBeSubtracted = Math.min(toBeSubtracted, Math.abs(nums[i] - val));
        }

        if(ct%2 == 1)
        {
            ans = ans - toBeSubtracted;
        }

        return ans;
    }
}