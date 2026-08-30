class Solution {
    public int minimumDeletions(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int maxIdx = -1, minIdx = -1;
        int len = nums.length;

        for(int i = 0; i < len; i++)
        {
            if(nums[i] > maxi)
            {
                maxi = nums[i];
                maxIdx = i;
            }
            if(nums[i] < mini)
            {
                mini = nums[i];
                minIdx = i;
            }
        }

        int maxDeletions = 0;
        int minDeletions = 0;
        int leftIdx = 0, rightIdx = 0;
        int total = len;

        leftIdx = Math.min(maxIdx, minIdx);
        rightIdx = Math.max(maxIdx, minIdx);

        total = Math.min(total, (leftIdx + 1) + (len - rightIdx));
        total = Math.min(total, rightIdx + 1);
        total = Math.min(total, len - leftIdx);
        
        return total;

        
    }
}