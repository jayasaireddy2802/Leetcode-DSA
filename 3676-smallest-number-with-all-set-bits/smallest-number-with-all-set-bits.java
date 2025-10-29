// class Solution {

//     public boolean isValid(int num)
//     {
//         while(num > 0)
//         {
//             if((num & 1) == 0)
//                 return false;
//             num = num >> 1;
//         }
            
//         return true;
        
//     }
//     public int smallestNumber(int n) {
//         int ans = n;

//         while(ans < 1000_000_000)
//         {
//             if(isValid(ans))
//             {
//                 return ans;
//             }
//             ans++;
//         }
//         return -1;
//     }
// }


class Solution {

    public boolean isValid(int num)
    {
        return (Integer.bitCount(num) == (32 - Integer.numberOfLeadingZeros(num)));        
    }
    public int smallestNumber(int n) {
        int ans = n;

        while(ans < 1000_000_000)
        {
            if(isValid(ans))
            {
                return ans;
            }
            ans++;
        }
        return -1;
    }
}