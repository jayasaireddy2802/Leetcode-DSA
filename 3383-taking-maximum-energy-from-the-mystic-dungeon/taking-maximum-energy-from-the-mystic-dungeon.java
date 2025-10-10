// class Solution {    

//     public int maximumEnergy(int[] energy, int k) {

//         int n = energy.length;
//         int ans = Integer.MIN_VALUE;

//         for(int i = 0; i < n; i++)
//         {
//             int val = 0;
//             for(int j = i; j < n; j = j + k)
//             {
//                 val += energy[j];
//             }
//             ans = Math.max(ans, val);
//         }
        
//         return ans;
//     }
// }

class Solution {    

    public int maximumEnergy(int[] energy, int k) {

        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for(int i = n-1; i >= 0; i--)
        {
            dp[i] = energy[i];
            if((i + k) < n)
                dp[i] = dp[i] + dp[i + k];
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}