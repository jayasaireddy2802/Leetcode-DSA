// class Solution {

//     public boolean onlyOnes(int i, int j, String s)
//     {
//         for(int k = i; k <= j; k++)
//         {
//             if(s.charAt(k) == '0')
//                 return false;
//         }

//         return true;
//     }

//     public int numSub(String s) {
//         int len = s.length();
//         int ct = 0;
//         int mod = 1000000007;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if(onlyOnes(i, j, s))
//                     ct = (ct + 1) % mod;
//             }
//         }

//         return ct;
//     }
// }


// // 
// class Solution {

//     public int numSub(String s) {
//         int len = s.length();
//         int ct = 0;
//         int mod = 1000000007;
//         int val = 0;

//         for(int i = 0; i < len; i++)
//         {
//             if(s.charAt(i) == '1')
//                 val++;

//             else
//             {
//                 ct = (ct % mod + ((val * (val + 1)) / 2) % mod) % mod;
//                 val = 0;
//             }
//         }

//         ct = (ct % mod + ((val * (val + 1)) / 2) % mod) % mod;

//         return ct;
//     }
// }



class Solution {

    public int numSub(String s) {
        int len = s.length();
        long ct = 0;
        long mod = 1000000007;
        long val = 0;

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '1')
                val++;

            else
            {
                ct = (ct % mod + ((val * (val + 1)) / 2) % mod) % mod;
                val = 0;
            }
        }

        ct = (ct % mod + ((val * (val + 1)) / 2) % mod) % mod;

        return (int) ct;
    }
}