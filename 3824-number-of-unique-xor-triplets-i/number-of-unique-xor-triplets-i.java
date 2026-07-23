class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        int ans = 1;

        if(len == 1 || len == 2)
            return len;

        while(ans <= len)
            ans = ans * 2;
        
        return ans;
        
    }
}