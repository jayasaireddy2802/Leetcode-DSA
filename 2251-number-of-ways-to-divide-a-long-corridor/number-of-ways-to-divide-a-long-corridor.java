class Solution {
    public int numberOfWays(String corridor) {
        int len = corridor.length();
        long ans = 1;
        int mod = 1000000007;
        int seats = 0;
        int ct = 0;

        for(int i = 0; i < len; i++)
        {
            char ch = corridor.charAt(i);
            if(ch == 'S')
                seats++;
            if(seats == 2)
                ct++;
            if(seats == 3)
            {
                seats = 1;
                ans = (ans * ct) % mod;
                ct = 0;
            }
        }

        if(seats != 2)
            return 0;
        return (int)ans;
    }
}