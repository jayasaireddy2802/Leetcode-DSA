// class Solution {
//     public int triangularSum(int[] nums) {
        
//         List<Integer> list = Arrays.stream(nums).boxed().toList();

//         while(true)
//         {
//             int size = list.size();
//             if(size == 1)
//                 return list.get(0);

//             List<Integer> newList = new ArrayList<>();

//             for(int i = 0; i < size - 1; i++)
//             {
//                 newList.add((list.get(i) + list.get(i + 1)) % 10);
//             }

//             list = newList;
//         }
//     }
// }


class Solution {
    public int triangularSum(int[] nums) {
        
        int len = nums.length;

        for(int size = len - 1; size > 0; size--)
        {
            for(int i = 0; i < size; i++)
            {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}