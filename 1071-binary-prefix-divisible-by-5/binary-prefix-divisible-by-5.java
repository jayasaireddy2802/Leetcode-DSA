// class Solution {
//     public List<Boolean> prefixesDivBy5(int[] nums) {
//         List<Boolean> list = new ArrayList<>();
//         long val = 0;
    
//         for(int i = 0; i < nums.length; i++)
//         {
//             val = (val << 1) ^ nums[i]; 
//             if(val % 5 == 0)
//                 list.add(true);
//             else
//                 list.add(false);
//         }

//         return list;
//     }
// }

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        long val = 0;
    
        for(int i = 0; i < nums.length; i++)
        {
            val = ((val << 1) ^ nums[i]) % 5; 
            if(val == 0)
                list.add(true);
            else
                list.add(false);
        }

        return list;
    }
}