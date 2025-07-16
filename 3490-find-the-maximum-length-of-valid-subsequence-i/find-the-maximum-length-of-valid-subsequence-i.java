class Solution {
    public int maximumLength(int[] nums) {
        int ct = 0;
        int ans = 0;
        int len = nums.length;

        // odd even sequence
        int idx = 0;
        boolean odd = false;
        for(idx = 0; idx < len; idx++)
        {
            if(nums[idx] % 2 == 1)
                break;
        }
        ct = 1;
        for(int i = idx; i < len; i++)
        {
            if(odd)
            {
                if(nums[i] % 2 == 1)
                {
                    ct++;
                    odd = false;
                }
            }
            else
            {
                if(nums[i] % 2 == 0)
                {
                    ct++;
                    odd = true;
                }
            }
        }
        ans = Math.max(ans, ct);

        // even odd sequence
        ct = 0;
        idx = 0;
        boolean even = false;
        for(idx = 0; idx < len; idx++)
        {
            if(nums[idx] % 2 == 0)
                break;
        }
        ct = 1;
        for(int i = idx; i < len; i++)
        {
            if(even)
            {
                if(nums[i] % 2 == 0)
                {
                    ct++;
                    even = false;
                }
            }
            else
            {
                if(nums[i] % 2 == 1)
                {
                    ct++;
                    even = true;
                }
            }
        }
        ans = Math.max(ans, ct);

        // even even
        ct = 0;
        for(int num : nums)
        {
            if(num % 2 == 0)
                ct++;
        }
        ans = Math.max(ans, ct);

        // odd odd
        ct = 0;
        for(int num : nums)
        {
            if(num % 2 == 1)
                ct++;
        }
        ans = Math.max(ans, ct);


        return ans;
    }
}