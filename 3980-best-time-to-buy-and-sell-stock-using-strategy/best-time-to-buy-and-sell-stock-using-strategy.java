// class Solution {
//     public long maxProfit(int[] prices, int[] strategy, int k) {
//         long maxi = Long.MIN_VALUE;
//         int len = prices.length;
//         long sum = 0;

//         for(int i = 0; i < len; i++)
//         {
//             sum += prices[i] * strategy[i];
//         }

//         maxi = Math.max(maxi, sum);

//         for(int i = 0; i + k <= len; i++)
//         {
//             sum = 0;
//             int j = 0;
//             while(j < i)
//             {
//                 sum += prices[j] * strategy[j];
//                 j++;
//             }

//             j = k/2;
//             while(j < k)
//             {
//                 sum += prices[i + j];
//                 j++;
//             }

//             j = i + k;
//             while(j < len)
//             {
//                 sum += prices[j] * strategy[j];
//                 j++;
//             }

//             maxi = Math.max(maxi, sum);
//         }

//         maxi = Math.max(maxi, sum);

//         return maxi;
//     }
// }


class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long maxi = Long.MIN_VALUE;
        int len = prices.length;
        long sum = 0;

        for(int i = 0; i < len; i++)
        {
            sum += prices[i] * strategy[i];
        }

        maxi = Math.max(maxi, sum);
        long leftSum = 0;
        long rightSum = 0;

        for (int i = k; i < len; i++) {
            rightSum += (long) prices[i] * strategy[i];
        }

        for(int i = 0; i + k <= len; i++)
        {
            sum = 0;
            int j = 0;
            sum += leftSum;

            j = k/2;
            while(j < k)
            {
                sum += prices[i + j];
                j++;
            }

            sum += rightSum;
            if(i + k < len)
                rightSum -= prices[i + k] * strategy[i + k];
            leftSum += prices[i] * strategy[i];

            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }
}