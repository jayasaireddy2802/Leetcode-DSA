class Solution {
    public int missingMultiple(int[] nums, int k) {
        int len = nums.length;
        boolean[] isPresent = new boolean[201];

        for(int i = 0; i < len; i++)
        {
            isPresent[nums[i]] = true;
        }

        int val = k;
        while(true)
        {
            if(!isPresent[val]) return val;
            val += k;
        }
    }
}