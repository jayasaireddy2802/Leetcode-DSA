// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if(n <= 0)
//             return false;

//         int num = n;

//         while(num%4 == 0)
//         {
//             num /= 4;
//         }

//         return (num == 1) ? true : false;
//     }
// }


class Solution {
    public boolean isPowerOfFour(int n) {

        double res = Math.log10(n) / Math.log10(4);
        return (res == (int)res) ? true : false;
    }
}