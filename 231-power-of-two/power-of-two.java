// class Solution {
//     public boolean isPowerOfTwo(int n) {

//         if(n <= 0)
//             return false;

//         int num = n;
//         while(num > 1)
//         {
//             if(num % 2 == 0)
//                 num /= 2;
//             else
//                 return false;
//         }
//         return true;

//     }
// }

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
            
        if((n & (n - 1)) == 0)
            return true;
        else
            return false;
    }
}