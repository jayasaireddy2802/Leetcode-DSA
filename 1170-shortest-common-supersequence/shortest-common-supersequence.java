class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1; i < len1+1; i++)
        {
            for(int j = 1; j < len2+1; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        String res = "";
        int i = len1;
        int j = len2;

        while(i > 0 && j > 0)
        {
            if(str1.charAt(i-1) == str2.charAt(j-1))
            {
                res = res + str1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
            {
                res = res + str1.charAt(i-1);
                i--;
            }
            else
            {
                res = res + str2.charAt(j-1);
                j--;
            }
        }

        while(i > 0)
        {
            res = res + str1.charAt(i-1);
            i--;
        }

        while(j > 0)
        {
            res = res + str2.charAt(j-1);
            j--;
        }

        String ans = "";
        int l = res.length();
        for(i = l-1; i >= 0; i--)
        {
            ans = ans + res.charAt(i);
        }

        return ans;
    }
}