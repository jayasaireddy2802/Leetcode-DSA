// class Solution {
//     public int countOdds(int low, int high) {
//         int ct = 0;

//         for(int k = low; k <= high; k++)
//         {
//             if(k % 2 == 1)
//                 ct++;
//         }

//         return ct;
//     }
// }


class Solution {
    public int countOdds(int low, int high) {
        int ct = 0;

        if(low % 2 == 0 && high % 2 == 0)
             return (high -low) /2;

        return (high - low)/2 + 1 ;
    }
}