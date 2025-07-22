// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         int len = nums.length;
//         int max = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 boolean[] visited = new boolean[100000];
//                 int sum = 0;
//                 for(int k = i; k <= j; k++)
//                 {
//                     if(visited[nums[k]])
//                     {
//                         sum = 0;
//                         break;
//                     }
//                     sum += nums[k];
//                     visited[nums[k]] = true;
//                 }
//                 max = Math.max(max, sum);
//             }
//         }

//         return max;
//     }
// }


class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int max = 0;
        int i = 0, j = 0, sum = 0;
        int[] visited = new int[100000];
        Arrays.fill(visited, -1);

        while(j < len)
        {
            if(visited[nums[j]] == -1)
            {
                sum += nums[j];
                visited[nums[j]] = j;
                j++;
            }
            else
            {
                max = Math.max(max, sum);
                int idx = visited[nums[j]];
                visited[nums[j]] = -1;
                while(i <= idx)
                {
                    visited[nums[i]] = -1;
                    sum -= nums[i];
                    i++;
                }
            }
        }

        max = Math.max(max, sum);
        return max;
    }
}