// class Solution {

//     public boolean solve(int idx, int val, int n, long[] prefix)
//     {
//         if(idx >= 30)
//             return false;
//         if(val > n)
//             return false;
//         if(val == n)
//             return true;

//         boolean nottake = solve(idx + 1, val, n, prefix);
//         boolean take = solve(idx + 1, val + (int)prefix[idx], n, prefix);

//         return nottake || take;
//     }

//     public boolean checkPowersOfThree(int n) {
//         long[] prefix = new long[30];
//         prefix[0] = 1;

//         for(int i = 1; i < 30; i++)
//         {
//             prefix[i] = prefix[i-1]*3;
//         }
        
//         return solve(0, 0, n, prefix);
//     }
// }


class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n > 0)
        {
            if(n % 3 == 2)
                return false;
            n = n/3;
        }
        return true;
    }
}