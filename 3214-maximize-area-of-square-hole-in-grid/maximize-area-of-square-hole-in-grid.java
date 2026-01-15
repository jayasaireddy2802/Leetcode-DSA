class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxh = 0;
        int maxv = 0;
        int len1 = hBars.length;
        int len2 = vBars.length;
        int ct = 1;

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        for(int i = 1; i < len1; i++)
        {
            if(hBars[i] == hBars[i-1] + 1)
            {
                ct++;
            }
            else
            {
                maxh = Math.max(maxh, ct);
                ct = 1;
            }
        }
        maxh = Math.max(maxh, ct);

        ct = 1;
        for(int i = 1; i < len2; i++)
        {
            if(vBars[i] == vBars[i-1] + 1)
            {
                ct++;
            }
            else
            {
                maxv = Math.max(maxv, ct);
                ct = 1;
            }
        }
        maxv = Math.max(maxv, ct);

        int ans = Math.min(maxv, maxh) + 1;
        return ans*ans;
    }
}