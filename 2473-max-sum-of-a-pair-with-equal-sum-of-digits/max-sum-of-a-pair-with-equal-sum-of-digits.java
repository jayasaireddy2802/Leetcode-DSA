// class Solution {

//     public int digitsSum(int num)
//     {
//         int sum = 0;
//         while(num > 0)
//         {
//             sum = sum + (num % 10);
//             num = num / 10;
//         }

//         return sum;
//     }

//     public int maximumSum(int[] nums) {
//         int n = nums.length;
//         int ans = -1;
//         for(int i = 0;i < n; i++)
//         {
//             for(int j = i + 1; j < n; j++)
//             {
//                 if(digitsSum(nums[i]) == digitsSum(nums[j]))
//                     ans = Math.max(ans, nums[i] + nums[j]);
//             }
//         }

//         return ans;
//     }
// }


// class Solution {

//     public int digitsSum(int num)
//     {
//         int sum = 0;
//         while(num > 0)
//         {
//             sum = sum + (num % 10);
//             num = num / 10;
//         }

//         return sum;
//     }

//     public int maximumSum(int[] nums) {
//         int n = nums.length;
//         int ans = -1;
//         int[] sum = new int[n];

//         for(int i = 0; i < n; i++)
//         {
//             sum[i] = digitsSum(nums[i]);
//         }

//         for(int i = 0;i < n; i++)
//         {
//             for(int j = i + 1; j < n; j++)
//             {
//                 if(sum[i] == sum[j])
//                     ans = Math.max(ans, nums[i] + nums[j]);
//             }
//         }

//         return ans;
//     }
// }


// class Solution {

//     public int digitsSum(int num)
//     {
//         int sum = 0;
//         while(num > 0)
//         {
//             sum = sum + (num % 10);
//             num = num / 10;
//         }

//         return sum;
//     }

//     public int maximumSum(int[] nums) {
//         int n = nums.length;
//         int ans = -1;
//         Map<Integer, List<Integer>> map =new HashMap<>();
//         for(int i = 0; i < n; i++)
//         {
//             int sum = digitsSum(nums[i]);
//             List<Integer> list;
//             if(!map.containsKey(sum))
//             {
//                 list = new ArrayList<>();
//             }
//             else
//             {
//                 list = map.get(sum);
//             }
//             list.add(nums[i]);
//             map.put(sum, list);
//         }

//         for(int key : map.keySet())
//         {
//             List<Integer> list = map.get(key);
//             int size = list.size();
//             if(size < 2)
//                 continue;
//             Collections.sort(list);
//             int num1 = list.get(size - 1);
//             int num2 = list.get(size - 2);
//             ans = Math.max(ans, num1 + num2);
//         }

//         return ans;
//     }
// }

class Solution {

    public int digitsSum(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            sum = sum + (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        Map<Integer, int[]> map =new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum = digitsSum(nums[i]);
            int[] arr = map.getOrDefault(sum, new int[]{-1, -1});

            if(nums[i] > arr[0])
            {
                arr[1] = arr[0];
                arr[0] = nums[i];
            }
            else if(nums[i] > arr[1])
            {
                arr[1] = nums[i];
            }

            if(arr[1] != -1)
            {
                ans = Math.max(ans, arr[0] +  arr[1]);
            }

            map.put(sum, arr);
        }

        

        return ans;
    }
}