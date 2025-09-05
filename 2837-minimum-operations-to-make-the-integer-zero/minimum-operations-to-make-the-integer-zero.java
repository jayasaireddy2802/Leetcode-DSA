// class Solution {

//     public int getCountOfSetBits(long val)
//     {
//         int ct = 0;
//         while(val > 0)
//         {
//             if((val & 1) != 0)
//                 ct++;
//             val = val >> 1;
//         }

//         return ct;
//     }

//     public int makeTheIntegerZero(int num1, int num2) {
//         int k = 0;

//         while(true)
//         {
//             long val = (long)num1 - (long)k*num2;
//             if(val < 0)
//                 return -1;
//             int min_bits = getCountOfSetBits(val);
//             if(min_bits <= k && k <= val)
//                 return k;
//             k++;
//         }
//     }
// }

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int k = 0;

        while(true)
        {
            long val = (long)num1 - (long)k*num2;
            if(val < 0)
                return -1;
            int min_bits = Long.bitCount(val);
            if(min_bits <= k && k <= val)
                return k;
            k++;
        }
    }
}