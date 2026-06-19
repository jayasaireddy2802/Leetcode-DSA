class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int ans = 0;

        for(int num : gain)
        {
            start = start + num;
            ans = Math.max(ans, start);
            
        }
        

        return ans;
    }
}