class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int ct = 0;


        for(int num : nums)
        {
            xor = xor ^ num;
            if(num == 0) ct++;
        }

        if(ct == nums.length) return 0;
        
        return xor == 0 ? nums.length - 1 : nums.length;
    }
}