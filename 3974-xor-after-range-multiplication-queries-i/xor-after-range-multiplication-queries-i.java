class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1000000007;

        for(int[] query : queries)
        {
            int idx = query[0];
            while(idx <= query[1])
            {
                nums[idx] = (int)(((long)nums[idx] * query[3]) % MOD);
                idx += query[2];
            }
        }

        int res = 0;
        for(int num : nums)
            res = res ^ num;
        
        return res;
    }
}