class Solution {
    public int findLHS(int[] nums) {

        int len = nums.length;
        int ans = 0;

        for(int i = 0; i < len; i++)
        {
            int l = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < len; j++)
            {
                if(nums[i] == nums[j] || (nums[i] - nums[j] == 1))
                {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    l++;
                }
            }
            if(max - min == 1)
                ans = Math.max(ans, l);
        }    

        return ans;
    }
}