// class Solution {
//     public long maxTotalValue(int[] nums, int k) {
//         int len = nums.length;
//         int[][] arr = new int[len*len][2];
//         int idx = 0;

//         for(int i = 0; i < len; i++)
//         {
//             int mini = Integer.MAX_VALUE;
//             int maxi = Integer.MIN_VALUE;
//             for(int j = i; j < len; j++)
//             {
//                 mini = Math.min(mini, nums[j]);
//                 maxi = Math.max(maxi, nums[j]);
//                 arr[idx][0] = mini;
//                 arr[idx++][1] = maxi;
//             }
//         }

//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
//         for(int[] res : arr)
//         {
//             pq.add(res[1] - res[0]);
//         }

//         int ans = 0;
        
//         while(k > 0 && !pq.isEmpty())
//         {
//             ans += pq.poll();
//             k--;
//         }

//         return ans;
//     }
// }


class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int len = nums.length;
        long ans = 1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);    
        }

        return (ans * k) * (maxi - mini);
    }
}