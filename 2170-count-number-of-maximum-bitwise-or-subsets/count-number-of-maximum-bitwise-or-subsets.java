// class Solution {

//     public void generateSubsequence(int idx, int[] nums, int val, List<Integer> list)
//     {
//         if(idx >= nums.length)
//         {
//             list.add(val);
//             return ;
//         }

//         generateSubsequence(idx + 1, nums, val | nums[idx], list);
//         generateSubsequence(idx + 1, nums, val , list);
//     }

//     public int countMaxOrSubsets(int[] nums) {
//         List<Integer> list = new ArrayList<>();

//         generateSubsequence(0, nums, 0, list);

//         int maxi = 0;
//         int ans = 0;

//         for(int num : list)
//             maxi = Math.max(maxi, num);
//         for(int num : list)
//         {
//             if(num == maxi)
//                 ans++;
//         }

//         return ans;
//     }
// }



// class Solution {

//     public int generateSubsequence(int idx, int[] nums, int val, int maxi)
//     {
//         if(idx >= nums.length)
//         {
//             if(val == maxi)
//                 return 1;
//             else
//                 return 0;
//         }

//         int l = generateSubsequence(idx + 1, nums, val | nums[idx], maxi);
//         int r = generateSubsequence(idx + 1, nums, val , maxi);

//         return l + r;
//     }

//     public int countMaxOrSubsets(int[] nums) {
//         int maxi = 0;
//         for(int num : nums)
//             maxi = maxi | num;

//         return generateSubsequence(0, nums, 0, maxi);

//     }
// }

class Solution {

    public int generateSubsequence(int idx, int[] nums, int val, int maxi, int[][] dp)
    {
        if(idx >= nums.length)
        {
            if(val == maxi)
                return 1;
            else
                return 0;
        }

        if(dp[idx][val] != -1)
            return dp[idx][val];

        int l = generateSubsequence(idx + 1, nums, val | nums[idx], maxi, dp);
        int r = generateSubsequence(idx + 1, nums, val , maxi, dp);

        return dp[idx][val] = l + r;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxi = 0;
        for(int num : nums)
            maxi = maxi | num;

        int[][] dp = new int[nums.length][200000];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return generateSubsequence(0, nums, 0, maxi, dp);

    }
}