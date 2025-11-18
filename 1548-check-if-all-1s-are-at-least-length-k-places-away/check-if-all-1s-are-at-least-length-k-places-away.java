class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int dis = 0;
        boolean first = true;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] == 1)
            {
                if(first)
                    first = false;
                else
                {
                    if(dis < k)
                        return false;
                }
                dis = 0;
            }
            else
                dis++;
        }

        return true;
    }
}