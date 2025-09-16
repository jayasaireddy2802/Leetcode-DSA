// it does not work
// class Solution {

//     private int getGCD(int a, int b)
//     {
//         if(a == 0)
//             return b;
//         if(b == 0)
//             return a;
        
//         return getGCD(b, a % b);
//     }

//     private int getLCM(int a, int b, int gcd)
//     {
//         return (a * b) / gcd;
//     }

//     public List<Integer> replaceNonCoprimes(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         int len = nums.length;
//         int i = 1;

//         if(len == 0)
//             return list;
        
//         list.add(nums[0]);
//         while(i < len)
//         {
//             int size = list.size();
//             int x = list.get(size - 1);
//             int y = nums[i];

//             int gcd = getGCD(x, y);
//             if(gcd == 1)
//             {
//                 list.add(nums[i]);
//                 i++;
//                 continue;
//             }

//             int lcm = getLCM(x, y, gcd);

//             list.remove(size - 1);
//             list.add(lcm);
//             i++;
//         }

//         return list;
//     }
// }



class Solution {

    private int getGCD(int a, int b)
    {
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        
        return getGCD(b, a % b);
    }

    private int getLCM(int a, int b, int gcd)
    {
        return (int)((long)a * b / gcd);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : nums)
        {
            while(!list.isEmpty())
            {
                int size = list.size();
                int prev = list.get(size - 1);
                int curr = num;

                int gcd = getGCD(prev, curr);
                if(gcd == 1)
                    break;

                int lcm = getLCM(prev, curr, gcd);
                list.remove(size - 1);

                num = lcm;
            }

            list.add(num);
        }

        return list;
    }
}