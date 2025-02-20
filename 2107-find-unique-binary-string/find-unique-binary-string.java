
// wrong approach
// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         int ans = 0;
//         int len = nums[0].length();
//         Set<String> set = new HashSet<>();
//         for(String binary : nums)
//         {
//             int num = Integer.parseInt(binary, 2);
//             ans = ans ^ num;
//             set.add(binary);
//         }
//         String res = Integer.toBinaryString(~ans);
//         String str = new StringBuilder(res).reverse().substring(0, len);
//         str =  new StringBuilder(str).reverse().toString();
//         if(set.contains(str))
//             return res;
//         else
//             return str;

//     }
// }



class Solution {
    public String findDifferentBinaryString(String[] nums) {
     
        int len = nums[0].length();
        int size = (int)1e6;

        int[] arr = new int[size];

        for(String binary : nums)
        {
            int num = Integer.parseInt(binary, 2);
             arr[num] = 1;
        }
        for(int i = 0; i < size; i++)
        {
            if(arr[i] == 0)
            {
                String ans = Integer.toBinaryString(i);

               if(i == 0)
               {
                int j = 0;
                String res = "";
                while(j < len){
                    res = res + '0';
                    j++;
                }

                return res;
               }
                if(ans.length() == len)
                    return ans;
            }
        }
        return "";
    }
}



