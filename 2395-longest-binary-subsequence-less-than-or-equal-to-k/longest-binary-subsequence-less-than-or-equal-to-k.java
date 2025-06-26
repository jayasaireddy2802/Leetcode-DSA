class Solution {
    public int longestSubsequence(String s, int k) {
        int len = s.length();
        int ct = 0;

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '0')
                ct++;
        }

        long num2 = 1;
        long res = 0;

        for(int i = len -1; i >= 0; i--)
        {
            if(s.charAt(i) == '1')
            {
                if(res + num2 <= k)
                {
                    ct++;
                    res = res + num2;
                }

            }

            num2 = num2 << 1;
            if(num2 > k)
                break;
        }

        return ct;
    }
}