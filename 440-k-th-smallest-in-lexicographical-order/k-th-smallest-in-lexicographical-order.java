// class Solution {

//     public void solve(int num, int n, List<Integer> ans)
//     {
//         if(num > n)
//             return ;

//         if(num <= n)
//             ans.add(num);
        
//         for(int i = 0; i <= 9; i++)
//         {
//             int newNum = num*10 + i;
//             solve(newNum, n, ans);
//         }
//     }

//     public int findKthNumber(int n, int k) {
//         List<Integer> ans = new ArrayList<>();

//         for(int i = 1; i <= 9; i++)
//         {
//             solve(i, n, ans);
//         }

//         return ans.get(k-1);
//     }
// }


// class Solution {

//     int ct;

//     public int solve(int num, int n, int k)
//     {
//         if(num > n)
//             return -1;

//         if(num <= n)
//             ct++;
        
//         if(ct == k)
//             return num;
        
//         for(int i = 0; i <= 9; i++)
//         {
//             int newNum = num*10 + i;
//             int ans = -1;
//             ans = solve(newNum, n, k);
//             if(ans != -1)
//                 return ans;
//         }

//         return -1;
//     }

//     public int findKthNumber(int n, int k) {
//         int ans = 0;
//         ct = 0;
//         for(int i = 1; i <= 9; i++)
//         {
//             ans = solve(i, n, k);
//             if(ans != -1)
//                 return ans;
//         }
//         return ans;
        
//     }
// }

class Solution {

    public int countNumbers(long curr, long next, int n)
    {
        long ct = 0;

        while(curr <= n)
        {
            ct = ct + (Math.min(next, (long)n + 1) - curr);
            curr = curr * 10;
            next = next * 10;
        }

        return (int)ct;
    }



    public int findKthNumber(int n, int k) {
        int count = 0;
        long curr = 1;
        k--;
        while(k > 0)
        {
            count = countNumbers(curr, curr + 1, n);
            if(count <= k)
            {
                curr = curr + 1;
                k = k - count;
            }
            else
            {
                curr = curr * 10;
                k--;
            }
        }

        return (int)curr;

    }
}