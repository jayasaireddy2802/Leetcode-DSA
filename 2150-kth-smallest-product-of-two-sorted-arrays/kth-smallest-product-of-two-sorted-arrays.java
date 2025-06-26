// class Solution {
//     public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//         int len1 = nums1.length;
//         int len2 = nums2.length;
//         PriorityQueue<Long> pq = new PriorityQueue<>();
        
//         for(int i = 0; i < len1; i++)
//         {
//             for(int j = 0; j < len2; j++)
//             {
//                 pq.add((long)nums1[i] * nums2[j]);
//             }
//         }

//         while(k > 1)
//         {
//             pq.poll();
//             k--;
//         }

//         return pq.poll();
        
//     }

// }

// class Solution {
//     public long kthSmallestProduct(int[] arr1, int[] arr2, long k) {
//         long low = -1_000_000_0000L; // -1e10
//         long high = 1_000_000_0000L; // 1e10
//         long answer = 0;

//         while (low <= high) {
//             long mid = low + (high - low) / 2;
//             long productCount = countProductsLessThanOrEqual(arr1, arr2, mid);

//             if (productCount >= k) {
//                 answer = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         return answer;
//     }

//     private long countProductsLessThanOrEqual(int[] arr1, int[] arr2, long targetProduct) {
//         long totalCount = 0;
//         int len2 = arr2.length;

//         for (int num1 : arr1) {
//             if (num1 >= 0) {
//                 int left = 0, right = len2 - 1, validPos = -1;
//                 while (left <= right) {
//                     int mid = left + (right - left) / 2;
//                     long product = 1L * num1 * arr2[mid];
//                     if (product <= targetProduct) {
//                         validPos = mid;
//                         left = mid + 1;
//                     } else {
//                         right = mid - 1;
//                     }
//                 }
//                 totalCount += (validPos + 1);
//             } else {
//                 int left = 0, right = len2 - 1, validPos = len2;
//                 while (left <= right) {
//                     int mid = left + (right - left) / 2;
//                     long product = 1L * num1 * arr2[mid];
//                     if (product <= targetProduct) {
//                         validPos = mid;
//                         right = mid - 1;
//                     } else {
//                         left = mid + 1;
//                     }
//                 }
//                 totalCount += (len2 - validPos);
//             }
//         }

//         return totalCount;
//     }
// }


class Solution {

    public boolean isPossible(int[] arr1, int[] arr2, long k, long product)
    {
        long totalCount = 0;
        int len = arr2.length;

        for(int num : arr1)
        {
            if(num >= 0)
            {
                int l = 0;
                int r = len - 1;

                while(l <= r)
                {
                    int mid = (l + r) / 2;
                    
                    if((long)arr2[mid] * num <= product)
                    {
                        l = mid + 1;
                    }
                    else
                    {
                        r = mid - 1;
                    }
                }

                totalCount += l;
            }

            else
            {
                int l = 0;
                int r = len - 1;

                while(l <= r)
                {
                    int mid = (l + r) / 2;
                    
                    if((long)arr2[mid] * num <= product)
                    {
                        r = mid - 1;
                    }
                    else
                    {
                        l = mid + 1;
                    }
                }

                totalCount += len - l;
            }
        }

        return totalCount >= k;
    }

    public long kthSmallestProduct(int[] arr1, int[] arr2, long k) {
        long left = (long)-1e10;
        long right = (long)1e10;
        long ans = 0;
        while(left <= right)
        {
            long mid = (left + right) / 2;

            if(isPossible(arr1, arr2, k, mid))
            {
                ans = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }
}