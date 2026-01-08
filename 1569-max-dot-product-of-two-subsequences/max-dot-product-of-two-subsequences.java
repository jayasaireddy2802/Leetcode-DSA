// class Solution {

//     public int solve(int i, int j, int[] nums1, int[] nums2)
//     {
//         int len1 = nums1.length;
//         int len2 = nums2.length;

//         if(i == len1 || j == len2)
//         {
//             return -1000000;
//         }

//         int val1 = nums1[i] * nums2[j];
//         int val2 = nums1[i] * nums2[j] + solve(i+1, j+1, nums1, nums2);
//         int val3 = solve(i, j + 1, nums1, nums2);
//         int val4 = solve(i + 1, j, nums1, nums2);

//         return Math.max(val1, Math.max(val2, Math.max(val3, val4))); 
//     }
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         return solve(0, 0, nums1, nums2);

//     }
// }



class Solution {

    public int solve(int i, int j, int[] nums1, int[] nums2, int[][] dp)
    {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(i == len1 || j == len2)
        {
            return -1000000;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        int val1 = nums1[i] * nums2[j];
        int val2 = nums1[i] * nums2[j] + solve(i+1, j+1, nums1, nums2, dp);
        int val3 = solve(i, j + 1, nums1, nums2, dp);
        int val4 = solve(i + 1, j, nums1, nums2, dp);

        return dp[i][j] = Math.max(val1, Math.max(val2, Math.max(val3, val4))); 
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return solve(0, 0, nums1, nums2, dp);

    }
}