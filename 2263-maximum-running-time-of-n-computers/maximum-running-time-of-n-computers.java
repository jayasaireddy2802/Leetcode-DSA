// class Solution {
//     public boolean isPossible(int n, int[] batteries, long ans)
//     {
//         long sum = 0;
//         long val = n * ans;

//         for(int num : batteries)
//         {
//             sum += Math.min(num, ans);
//             if(sum >= val)
//                 return true;
//         }

//         return false;
//     }

//     public long maxRunTime(int n, int[] batteries) {
//         long ans = 0;

//         while(true)
//         {
//             if(isPossible(n, batteries, ans))
//             {
//                 ans++;
//             }
//             else
//                 return --ans;
//         }
//     }
// }


class Solution {
    public boolean isPossible(int n, int[] batteries, long ans)
    {
        long sum = 0;
        long val = n * ans;

        for(int num : batteries)
        {
            sum += Math.min(num, ans);
            if(sum >= val)
                return true;
        }

        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
        long ans = 0;
        long l = 0;
        long sum = 0;
        for (int b : batteries) sum += b;
        long r = sum / n;

        while(l <= r)
        {
            long mid = l + (r - l) / 2;
            if(isPossible(n, batteries, mid))
            {
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return ans;
    }
}