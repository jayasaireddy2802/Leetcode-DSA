// class Solution {
//     public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int[] nums : nums1)
//         {
//             if(map.containsKey(nums[0]))
//             {
//                 map.put(nums[0], map.get(nums[0]) + nums[1]);
//             }
//             else
//                 map.put(nums[0], nums[1]);
//         }

//         for(int[] nums : nums2)
//         {
//             if(map.containsKey(nums[0]))
//             {
//                 map.put(nums[0], map.get(nums[0]) + nums[1]);
//             }
//             else
//                 map.put(nums[0], nums[1]);
//         }
        
//         int size = map.size();
//         int[][] res = new int[size][2];

//         int i = 0;
//         for(int x : map.keySet())
//         {
//             res[i][0] = x;
//             res[i][1] = map.get(x);
//             i++;
//         }

//         Arrays.sort(res, (a, b) -> a[0] - b[0]);
//         return res;
//     }
// }

// class Solution {
//     public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
//         Map<Integer, Integer> map = new TreeMap<>();
        
//         for(int[] nums : nums1)
//         {
//             if(map.containsKey(nums[0]))
//             {
//                 map.put(nums[0], map.get(nums[0]) + nums[1]);
//             }
//             else
//                 map.put(nums[0], nums[1]);
//         }

//         for(int[] nums : nums2)
//         {
//             if(map.containsKey(nums[0]))
//             {
//                 map.put(nums[0], map.get(nums[0]) + nums[1]);
//             }
//             else
//                 map.put(nums[0], nums[1]);
//         }
        
//         int size = map.size();
//         int[][] res = new int[size][2];

//         int i = 0;
//         for(int x : map.keySet())
//         {
//             res[i][0] = x;
//             res[i][1] = map.get(x);
//             i++;
//         }

        
//         return res;
//     }
// }


class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;

        while(i < len1 && j < len2)
        {
            if(nums1[i][0] < nums2[j][0])
            {
                if(map.containsKey(nums1[i][0]))
                {
                    map.put(nums1[i][0], map.get(nums1[i][0]) + nums1[i][1]);
                }
                else
                    map.put(nums1[i][0], nums1[i][1]);
                i++;
            }
            else
            {
                if(map.containsKey(nums2[j][0]))
                {
                    map.put(nums2[j][0], map.get(nums2[j][0]) + nums2[j][1]);
                }
                else
                    map.put(nums2[j][0], nums2[j][1]);
                j++;
            }
        }

        while(i < len1)
        {
            if(map.containsKey(nums1[i][0]))
            {
                map.put(nums1[i][0], map.get(nums1[i][0]) + nums1[i][1]);
            }
            else
                map.put(nums1[i][0], nums1[i][1]);
            i++;
        }

        while(j < len2)
        {
            if(map.containsKey(nums2[j][0]))
            {
                map.put(nums2[j][0], map.get(nums2[j][0]) + nums2[j][1]);
            }
            else
                map.put(nums2[j][0], nums2[j][1]);
            j++;
        }
        
        int size = map.size();
        int[][] res = new int[size][2];

        int k = 0;
        for(int x : map.keySet())
        {
            res[k][0] = x;
            res[k][1] = map.get(x);
            k++;
        }

        
        return res;
    }
}



