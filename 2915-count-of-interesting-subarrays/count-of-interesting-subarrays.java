// class Solution {
    
//     private boolean check(int i, int j, List<Integer> nums, int modulo, int k)
//     {
//         int ct = 0;

//         for(int x = i; x <= j; x++)
//         {
//             if((nums.get(x) % modulo) == k)
//                 ct++;
//         }

//         return (ct % modulo) == k;
//     }

//     public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//         int len = nums.size();
//         int cnt = 0;
//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if(check(i, j, nums, modulo, k))
//                     cnt++;
//             }
//         }
//         return cnt;
//     }
// }


class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int len = nums.size();
        List<Integer> num = new ArrayList<>();
        for(int x : nums)
        {
            if(x % modulo == k)
                num.add(1);
            else
                num.add(0);
        }

        Map<Long, Long> map = new HashMap<>();
        long cnt = 0;
        long sum = 0;

        map.put((long)0, (long)1);
        for(int i = 0; i < len; i++)
        {
            sum = sum + num.get(i);
            long r1 = sum % modulo;
            long r2 = (r1 - k + modulo) % modulo;
            cnt = cnt + map.getOrDefault(r2, (long)0);
            map.put(r1, map.getOrDefault(r1, (long)0) + 1);
        }

        return cnt;
    }
}