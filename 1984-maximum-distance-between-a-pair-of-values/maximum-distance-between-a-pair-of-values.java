// class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int maxi = 0;
//         int len1 = nums1.length;
//         int len2 = nums2.length;

//         for(int j = 0; j < len2; j++)
//         {
//             int idx = Math.min(j, len1 - 1);
//             for(int i = 0; i <= idx; i++)
//             {
//                 if(nums1[i] <= nums2[j])
//                 {
//                     maxi = Math.max(maxi, j - i);
//                 }
//             }
//         }

//         return maxi;
//     }
// }


class Solution {

    public int binarySearch(int[] nums1, int num2, int idx)
    {
        int len1 = nums1.length;
        int i = 0;
        int j = Math.min(idx, len1 - 1);
        int res = -1;

        while(i <= j)
        {
            int mid = i + (j - i) / 2 ;
            if(nums1[mid] <= num2) 
            {
                res = mid;
                j = mid - 1;
            }
            else 
                i = mid + 1;               
        }

        return res;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxi = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        for(int j = 0; j < len2; j++)
        {
            int i = binarySearch(nums1, nums2[j], j);
            if(i != -1)
                maxi = Math.max(maxi, j - i);
        }

        return maxi;
    }
}