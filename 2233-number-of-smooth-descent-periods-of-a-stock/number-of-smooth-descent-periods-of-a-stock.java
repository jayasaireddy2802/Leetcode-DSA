class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int len = prices.length;
        int i = 0, j = 1;

        while(j < len)
        {
            if(prices[j] != prices[j - 1] - 1)
            {
                long l = j - i;
                long val = (l*(l+1))/2;
                ans = ans + val;
                i = j;
            }
            j++;
        }

        long l = len - i;
        long val = (l*(l+1))/2;
        ans = ans + val;

        return ans;
    }
}

