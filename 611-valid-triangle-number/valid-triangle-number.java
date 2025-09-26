// class Solution {

//     private boolean isValid(int a, int b, int c)
//     {
//         return (a + b > c) && (a + c > b) && (b + c > a);
//     }

//     public int triangleNumber(int[] nums) {
//         int len = nums.length;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i + 1; j < len; j++)
//             {
//                 for(int k = j + 1; k < len; k++)
//                 {
//                     if(isValid(nums[i], nums[j], nums[k]))
//                     {
//                         ct++;
//                     }
//                 }
//             }
//         }

//         return ct;
//     }
// }



// if a <= b <= c then  we only check a + b > c

class Solution {

    public int binarySearch(int x, int y, int[] nums)
    {
        int ans = -1;
        int i = y + 1, j = nums.length - 1;
        int a = nums[x];
        int b = nums[y];

        while(i <= j)
        {
            int mid = (i + j) / 2;
            if(a + b > nums[mid])
            {
                ans = mid;
                i = mid + 1;
            }
            else
            {
                j = mid - 1;
            }
        }

        return ans;
    }

    public int triangleNumber(int[] nums) {
        int len = nums.length;
        int ct = 0;
        Arrays.sort(nums);

        for(int i = 0; i < len; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                int idx = binarySearch(i, j, nums);
                if(idx != -1)
                {
                    ct = ct + (idx - j);
                }
            }
        }


        return ct;
    }
}
