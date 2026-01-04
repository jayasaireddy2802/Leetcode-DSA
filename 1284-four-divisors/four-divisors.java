// class Solution {

//     public int solve(int num )
//     {
//         List<Integer> list = new ArrayList<>();

//         for(int i = 1; i <= num; i++)
//         {
//             if(num % i == 0)
//                 list.add(i);
//         }

//         int sum = 0;
//         if(list.size() == 4)
//         {
//             for(int val : list)
//                 sum += val;
//         }

//         if(sum == 0)
//             return -1;
//         return sum;
//     }
//     public int sumFourDivisors(int[] nums) {
//         int sum = 0;

//         for(int num : nums)
//         {
//             int val = solve(num);
//             if(val != -1)
//             {
//                 sum += val;
//             }
//         }

//         return sum;
        
//     }
// }


// class Solution {

//     public int solve(int num )
//     {
//         int ct = 0;
//         int sum = 0;

//         for(int i = 1; i <= num; i++)
//         {
//             if(ct >= 4)
//                 return 0;
//             if(num % i == 0)
//             {
//                 sum += i;
//                 ct++;
//             }
//         }

//         if(ct == 4)
//             return sum;
//         return 0;
//     }
//     public int sumFourDivisors(int[] nums) {
//         int sum = 0;

//         for(int num : nums)
//         {
//             int val = solve(num);
//             if(val != -1)
//             {
//                 sum += val;
//             }
//         }

//         return sum;
        
//     }
// }




class Solution {

    public int solve(int num )
    {
        int ct = 0;
        int sum = 0;
        int num1 = (int) Math.sqrt(num);

        for(int i = 1; i <= num1; i++)
        {            
            
            if(num % i == 0)
            {
                int j = num / i;

                if(i == j)
                {
                    sum += i;
                    ct++;
                }
                else
                {
                    sum += i;
                    sum += (num / i);
                    ct += 2;
                }

                if(ct > 4)
                return 0;
            }
        }

        if(ct == 4)
            return sum;
        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for(int num : nums)
        {
            int val = solve(num);
            if(val != -1)
            {
                sum += val;
            }
        }

        return sum;
        
    }
}