// class Solution {
//     public int solve(int i, int j, int len1, int len2, String s1, String s2)
//     {        
//         if(i == len1)
//         {
//             int val = 0;
//             while(j < len2)
//             {
//                 val += s2.charAt(j);
//                 j++;
//             }
//             return val;
//         }
//         if(j == len2)
//         {
//             int val = 0;
//             while(i < len1)
//             {
//                 val += s1.charAt(i);
//                 i++;
//             }
//             return val;
//         }

//         int mini = Integer.MAX_VALUE;
//         if(s1.charAt(i) != s2.charAt(j))
//         {
//             int left = s1.charAt(i) + solve(i + 1, j, len1, len2, s1, s2);
//             int right = s2.charAt(j) + solve(i, j + 1, len1, len2, s1, s2);
//             mini = Math.min(left, right);
//         }
//         else
//             mini = Math.min(mini, solve(i + 1, j + 1, len1, len2, s1, s2));
        
//         return mini;
//     }

//     public int minimumDeleteSum(String s1, String s2) {
//         return solve(0, 0, s1.length(), s2.length(), s1, s2);
//     }
// }



class Solution {
    public int solve(int i, int j, int len1, int len2, String s1, String s2, int[][] dp)
    {        
        if(i == len1)
        {
            int val = 0;
            while(j < len2)
            {
                val += s2.charAt(j);
                j++;
            }
            return val;
        }
        if(j == len2)
        {
            int val = 0;
            while(i < len1)
            {
                val += s1.charAt(i);
                i++;
            }
            return val;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        if(s1.charAt(i) != s2.charAt(j))
        {
            int left = s1.charAt(i) + solve(i + 1, j, len1, len2, s1, s2, dp);
            int right = s2.charAt(j) + solve(i, j + 1, len1, len2, s1, s2, dp);
            mini = Math.min(left, right);
        }
        else
            mini = Math.min(mini, solve(i + 1, j + 1, len1, len2, s1, s2, dp));
        
        return dp[i][j] = mini;
    }

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];

        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(0, 0, len1, len2, s1, s2, dp);
    }
}