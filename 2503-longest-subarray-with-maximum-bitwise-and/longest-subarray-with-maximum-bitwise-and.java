class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int max = 0;

        for(int num : nums)
            max = Math.max(max, num);
        
        int ans = 0;
        int res = 0;

        for(int num : nums)
        {
            if(num == max)
            {
                res++;
            }
            else
            {
                ans = Math.max(ans, res);
                res = 0;
            }
        }

        ans = Math.max(ans, res);
        return ans;
    }
}