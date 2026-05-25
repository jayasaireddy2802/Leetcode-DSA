// class Solution {

//     public boolean solve(int idx, String s, int minJump, int maxJump)
//     {
//         int len = s.length();

//         if(idx >= len)
//             return false;

//         if(idx == len - 1)
//             return true;
        
//         int right = Math.min(idx + maxJump, len - 1);

//         for(int i = idx + minJump; i <= right; i++)
//         {
//             if(s.charAt(i) == '0')
//             {
//                 if(solve(i, s, minJump, maxJump))
//                     return true;
//             }
//         }

//         return false;
//     }
//     public boolean canReach(String s, int minJump, int maxJump) {
//         return solve(0, s, minJump, maxJump);
//     }
// }



// class Solution {

//     public boolean solve(int idx, String s, int minJump, int maxJump, int[] dp)
//     {
//         int len = s.length();

//         if(idx >= len)
//             return false;

//         if(idx == len - 1)
//             return true;
        
//         if(dp[idx] != 0)
//         {
//             if(dp[idx] == 1)
//                 return true;
//             else
//                 return false;
//         }
        
//         int right = Math.min(idx + maxJump, len - 1);

//         for(int i = idx + minJump; i <= right; i++)
//         {
//             if(s.charAt(i) == '0')
//             {
//                 if(solve(i, s, minJump, maxJump, dp))
//                 {
//                     dp[idx] = 1;
//                     return true;
//                 }
//             }
//         }

//         dp[idx] = 2;
//         return false;
//     }
//     public boolean canReach(String s, int minJump, int maxJump) {

//         int[] dp = new int[s.length()];
//         return solve(0, s, minJump, maxJump, dp);
//     }
// }



class Solution {
      
    public boolean canReach(String s, int minJump, int maxJump) {

        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        int ct = 0;

        for(int i = 1; i < len; i++)
        {
            if(i - minJump >= 0)
                ct += dp[i - minJump];
            if(i - maxJump - 1>= 0)
                ct -= dp[i - maxJump - 1];
            if(ct > 0 && s.charAt(i) == '0')
                dp[i] = 1;
        }

        return dp[len - 1] > 0 ? true : false;

        
    }
}