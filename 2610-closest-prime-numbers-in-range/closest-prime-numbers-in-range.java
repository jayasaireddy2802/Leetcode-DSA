// class Solution {

//     static boolean[] seive;
//     static List<Integer> primes = new ArrayList<>();

//     static
//     {
//         int n = (int)1e6 + 20;
//         seive = new boolean[n];
//         Arrays.fill(seive, true);
//         seive[0] = false;
//         seive[1] = false;

//         for(int i = 2; i < n; i++)
//         {
//             if(seive[i] == true)
//             {
//                 for(long j = (long)i*i; j < n; j = j + i)
//                 {
//                     seive[(int)j] = false;
//                 }
//             }
//         }

//         for(int i = 2; i < n; i++)
//         {
//             if(seive[i])
//                 primes.add(i);
//         }

//     }

//     public int[] closestPrimes(int left, int right) {
//         int[] ans = new int[2];
//         ans[0] = -1;
//         ans[1] = -1;
//         List<Integer> nums = new ArrayList<>();

//         for(int num : primes)
//         {
//             if(num > right)
//                 break;
//             if(num >= left)
//                 nums.add(num);
//         }

//         int res = Integer.MAX_VALUE;
//         int l = nums.size();

//         for(int i = 0; i < l; i++)
//         {
//             for(int j = i + 1; j < l; j++)
//             {
//                 if(nums.get(j) - nums.get(i) < res){
//                     res = nums.get(j) - nums.get(i);
//                     ans[0] = nums.get(i);
//                     ans[1] = nums.get(j);
//                 }
//             }
//         }

//         return ans;
//     }
// }



class Solution {

    static boolean[] seive;
    static List<Integer> primes = new ArrayList<>();

    static
    {
        int n = (int)1e6 + 20;
        seive = new boolean[n];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;

        for(int i = 2; i < n; i++)
        {
            if(seive[i] == true)
            {
                for(long j = (long)i*i; j < n; j = j + i)
                {
                    seive[(int)j] = false;
                }
            }
        }

        for(int i = 2; i < n; i++)
        {
            if(seive[i])
                primes.add(i);
        }

    }

    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        List<Integer> nums = new ArrayList<>();

        for(int num : primes)
        {
            if(num > right)
                break;
            if(num >= left)
                nums.add(num);
        }

        int res = Integer.MAX_VALUE;
        int l = nums.size();


        for (int i = 1; i < l; i++) {
            int diff = nums.get(i) - nums.get(i - 1);
            if (diff < res) {
                res = diff;
                ans[0] = nums.get(i - 1);
                ans[1] = nums.get(i);
                if(diff <= 2)
                    return ans;
            }
        }

        return ans;
    }
}