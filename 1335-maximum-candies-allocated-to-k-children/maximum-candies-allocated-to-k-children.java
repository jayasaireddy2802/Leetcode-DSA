
// using linear checking tc = O(n^2)
// class Solution {

//     public boolean isPossible(int i, int[] candies, long k)
//     {
//         long ct = 0;
//         long remainingCount = 0;

//         for(int num : candies)
//         {
//             if(num >= i)
//                 ct++;
//             if((num - i) >= i)
//             {
//                 num = num - i;
//                 remainingCount = remainingCount + (num / i);
//             }
//         }

//         return (ct + remainingCount >= k);
    
//     }

//     public int maximumCandies(int[] candies, long k) {
//         int length = candies.length;
//         long sum = 0;
//         int maxi = Integer.MIN_VALUE;
//         int mini = Integer.MAX_VALUE;

//         for(int num : candies)
//         {
//             sum += num;
//             maxi = Math.max(maxi, num);
//             mini = Math.min(mini, num);
//         }

//         if(k > sum)
//             return 0;

//         for(int i = maxi; i >= 0; i--)
//         {
//             if(isPossible(i, candies, k))
//             {
//                 return i;
//             }
//         }
        
//         return 0;
//     }
// }

// using binary check
class Solution {

    public boolean isPossible(int i, int[] candies, long k)
    {
        long ct = 0;

        for(int num : candies)
        {
            ct = ct + num / i;
            if(ct >= k)
                return true;
        }

        return (ct >= k);
    }

    public int maximumCandies(int[] candies, long k) {
        int length = candies.length;
        long sum = 0;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for(int num : candies)
        {
            sum += num;
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }

        if(k > sum)
            return 0;

        int i = 1, j = maxi; 
        int ans = 0;
        while(i <= j)
        {
            int mid = (i + j) / 2;
            if(isPossible(mid, candies, k))
            {
                ans = mid;
                i = mid + 1;
            }
            else
                j = mid - 1;
        }
        return ans;
    }
}