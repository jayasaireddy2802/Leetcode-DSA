// class Solution {
//     int mini;
//     int maxi;

//     public void solve(int idx, int k, int score, int[] weights)
//     {
        
//         if(idx >= weights.length || k < 0)
//             return ;
//         if(idx == weights.length - 1 && k == 0)
//         {
//             mini = Math.min(mini, score);
//             maxi = Math.max(maxi, score);
//             return ;
//         }

//         for(int i = idx; i < weights.length; i++)
//         {
//             solve(i+1, k-1, score + weights[idx] + weights[i], weights);
//         }
//     }

//     public long putMarbles(int[] weights, int k) {
//         mini = Integer.MAX_VALUE;
//         maxi = Integer.MIN_VALUE;
//         solve(0, k, 0, weights);
//         System.out.print(maxi + " " + mini);
//         return maxi - mini;
//     }
// }


class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] pairSum = new long[n-1];

        for(int i = 0; i < n - 1; i++)
        {
            pairSum[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairSum);

        long maxSum = 0;
        long minSum = 0;

        for(int i = 0; i < k - 1; i++)
        {
            maxSum += pairSum[n-2-i];
            minSum += pairSum[i];
        }

        return maxSum - minSum;

    }
}