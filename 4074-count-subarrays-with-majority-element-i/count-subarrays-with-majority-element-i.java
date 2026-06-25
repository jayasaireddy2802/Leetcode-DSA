class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ct = 0;
        int ans = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++)
        {
            ct = 0;
            for(int j = i; j < len; j++)
            {
                if(nums[j] == target)
                    ct++;
                
                float size = j - i + 1;
                if(ct > size / 2)
                    ans++;
            }
        }

        return ans;

    }
}