class Solution {
    public int largestInteger(int[] nums, int k) {
        int res = -1;
        int len = nums.length;
        int[] freq = new int[52];

        if (k == len) {
            int max = -1;
            for (int num : nums) max = Math.max(max, num);
            return max;
        }
        
        if (k == 1) {
            for (int num : nums) freq[num]++;
            for (int i = 50; i >= 0; i--) {
                if (freq[i] == 1) return i;
            }
            return -1;
        }

        else
        {
            freq = new int[51];
            for (int num : nums) freq[num]++;

            res = -1;
            if (freq[nums[0]] == 1)
                res = Math.max(res, nums[0]);
            if (freq[nums[len - 1]] == 1)
                res = Math.max(res, nums[len - 1]);              
        }

        return res;
    }
}