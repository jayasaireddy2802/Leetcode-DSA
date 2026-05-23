class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int drops = 0;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] > nums[(i + 1) % len])
            {
                drops++;
            }
            if(drops > 1) return false;
        }

        return true;
    
    }
}