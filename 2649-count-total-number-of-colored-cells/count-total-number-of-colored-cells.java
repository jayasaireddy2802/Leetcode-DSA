class Solution {
    public long coloredCells(int n) {
        long ans = n*2 - 1;
        long x = ans;

        while(x > 0)
        {
            x = x - 2;
            if(x > 0)
                ans = ans + x*2;
        }

        return ans;
    }
}