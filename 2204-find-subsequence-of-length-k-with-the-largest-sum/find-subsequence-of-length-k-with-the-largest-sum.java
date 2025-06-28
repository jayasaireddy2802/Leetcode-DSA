// class Solution {
//     int res;
//     int[] ans;
//     ArrayList<Integer> list;

//     public void generateSubsequence(int idx, int[] nums, int k, int sum, int len)
//     {
//         int len1 = nums.length;

//         if(len == k)
//         {
//             if(sum > res)
//             {
//                 int i = 0;
//                 for(int num : list)
//                 {
//                     ans[i] = num;
//                     i++;
//                 }

//                 res = sum;
//             }
//             return ;
//         }            

//         if(idx >= len1)
//             return ;

//         list.add(nums[idx]);
//         generateSubsequence(idx + 1, nums, k, sum + nums[idx], len + 1);
//         list.remove(list.size() - 1);
//         generateSubsequence(idx + 1, nums, k, sum , len);

//         // return Math.max(take, nottake);

//     }

//     public int[] maxSubsequence(int[] nums, int k) {
//         ans = new int[k];
//         list = new ArrayList<>();
//         res = Integer.MIN_VALUE;

//         generateSubsequence(0, nums, k, 0, 0);

//         return ans;
//     }
// }



class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Store each number with its index
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

   
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        
        Arrays.sort(pairs, 0, k, (a, b) -> a[1] - b[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pairs[i][0];
        }

        return result;
    }
}
