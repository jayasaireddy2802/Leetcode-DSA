// class Solution {
//     public int smallestRepunitDivByK(int k) {
//         Set<Integer> set = new HashSet<>();
//         int length = 1;
//         int num = 1;

//         while(true)
//         {
//             if(num % k == 0)
//                 return length;
//             num = num % k;
//             num = num * 10 + 1;
//             length++;
//             if(set.contains(num))
//                 return -1;
//             set.add(num);
//         }
//     }
// }


class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int length = 1;
        int num = 1;

        while(length <= k)
        {
            if(num % k == 0)
                return length;
            num = num % k;
            num = num * 10 + 1;
            length++;
            if(set.contains(num))
                return -1;
            set.add(num);
        }

        return -1;
    }
}