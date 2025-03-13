// class Solution {

//     public boolean check(int[] nums)
//     {
//         for(int num : nums)
//         {
//             if(num > 0)
//                 return false;
//         }

//         return true;
//     }
//     public int minZeroArray(int[] nums, int[][] queries) {
//         int ct = 0;
//         if(check(nums))
//             return 0;
//         for(int[] query : queries)
//         {
//             int l = query[0];
//             int r = query[1];
//             int val = query[2];

//             for(int i = l; i <= r; i++)
//             {
//                 if(nums[i] > 0)
//                     nums[i] = nums[i] - val;
//             }

//             if(check(nums))
//                 return ++ct;
//             ct++;
//         }

//         return -1;
//     }
// }


// Difference array using linear check

// class Solution {

//     public boolean check(int[] nums)
//     {
//         for(int num : nums)
//         {
//             if(num != 0)
//                 return false;
//         }

//         return true;
//     }

//     public boolean compare(int[] nums, int k, int[][] query)
//     {
//         int n = nums.length;

//         int[] diffArray = new int[n];
//         for(int j = 0; j <= k; j++){
//         int l = query[j][0];
//         int r = query[j][1];
//         int val = query[j][2];

//         diffArray[l] = diffArray[l] + val;
//         if(r + 1 < n)
//             diffArray[r + 1] = diffArray[r + 1] - val;
//         }

//         int sum = 0;
//         for(int i = 0; i < n; i++)
//         {
//             sum = sum + diffArray[i];
//             diffArray[i] = sum;
//             if(nums[i] > diffArray[i]){
//                 return false;
//             }
//         }

//         return true;
//     }

//     public int minZeroArray(int[] nums, int[][] queries) {
//         int ct = 0;
//         int n = nums.length;

//         if(check(nums))
//             return 0;

//         for(int i = 0; i < queries.length; i++)
//         {
//             if(compare(nums, i, queries))
//             {
//                 return i + 1;
//             }
//         }

//         return -1;
//     }
// }




// Difference array using binary check

class Solution {

    public boolean check(int[] nums)
    {
        for(int num : nums)
        {
            if(num != 0)
                return false;
        }

        return true;
    }

    public boolean compare(int[] nums, int k, int[][] query)
    {
        int n = nums.length;

        int[] diffArray = new int[n];
        for(int j = 0; j <= k; j++){
        int l = query[j][0];
        int r = query[j][1];
        int val = query[j][2];

        diffArray[l] = diffArray[l] + val;
        if(r + 1 < n)
            diffArray[r + 1] = diffArray[r + 1] - val;
        }

        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum = sum + diffArray[i];
            diffArray[i] = sum;
            if(nums[i] > diffArray[i]){
                return false;
            }
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int ct = 0;
        int n = nums.length;

        if(check(nums))
            return 0;

        int ans = -1;
        int i = 0, j = queries.length - 1;
        while(i <= j)
        {
            int mid = (i + j)/2;
            if(compare(nums, mid, queries))
            {
                ans = mid + 1;
                j = mid -1;
            }
            else
                i = mid + 1;
        }

        return ans;
    }
}