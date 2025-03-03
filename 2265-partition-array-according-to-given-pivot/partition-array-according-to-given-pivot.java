// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         List<Integer> list1 = new ArrayList<>();
//         List<Integer> list2 = new ArrayList<>();
//         List<Integer> list3 = new ArrayList<>();
//         int n = nums.length;
//         int[] ans = new int[n];

//         for(int num : nums)
//         {
//             if(num == pivot)
//                 list2.add(num);
//             else if(num < pivot)
//                 list1.add(num);
//             else
//                 list3.add(num);
//         }

//         int i = 0;
//         for(int x : list1)
//         {
//             ans[i] = x;
//             i++;
//         }
//         for(int x : list2)
//         {
//             ans[i] = x;
//             i++;
//         }
//         for(int x : list3)
//         {
//             ans[i] = x;
//             i++;
//         }

//         return ans;
//     }
// }



// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         int ct = 0;
//         int idx = 0;

//         for(int i = 0; i < n; i++)
//         {
//             if(nums[i] == pivot)
//             {
//                 ct++;
//             }
//         }

//         for(int num : nums)
//         {
//             if(num < pivot)
//                 idx++;
//         }

//         while(ct > 0)
//         {
//             ans[idx] = pivot;
//             idx++;
//             ct--;
//         }

//         int i = 0;
//         int j = idx;

//         for(int num : nums)
//         {
//             if(num < pivot)
//             {
//                 ans[i] = num;
//                 i++;
//             }
//             else if(num > pivot)
//             {
//                 ans[j] = num;
//                 j++;
//             }
            
//         }

//         return ans;
//     }
// }


class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n-1, k=0, l=n-1;

        while(i < n && j >= 0)
        {
            if(nums[i] < pivot){
                ans[k] = nums[i];
                k++;
            }
            if(nums[j] > pivot)
            {
                ans[l] = nums[j];
                l--;
            }
            i++;
            j--;
        }

       

        while((l-k) >= 0)
        {
            ans[k] = pivot;
            k++;
        }

        return ans;
    }
}