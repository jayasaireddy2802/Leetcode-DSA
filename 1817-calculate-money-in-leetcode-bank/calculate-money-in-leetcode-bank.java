class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int start = 1;

        while(n > 0)
        {
            int k = start;
            for(int j = 0; j < 7 && n > 0; j++, n--)
                ans = ans + start + j;
            start++;
        }
        return ans;
    }
}