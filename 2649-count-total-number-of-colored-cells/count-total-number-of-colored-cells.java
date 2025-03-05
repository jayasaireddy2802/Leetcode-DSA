// class Solution {
//     public long coloredCells(int n) {
//         long ans = n*2 - 1;
//         long x = ans;

//         while(x > 0)
//         {
//             x = x - 2;
//             if(x > 0)
//                 ans = ans + x*2;
//         }

//         return ans;
//     }
// }


//progression formula
class Solution {
    public long coloredCells(int n) {
        long nth_term = n*2 - 1;
        long sum_of_n_terms = ((1 + nth_term)*n) / 2;
        long sum_of_second_last_terms = ((1 + nth_term - 2)*(n-1)) / 2;
        return sum_of_n_terms + sum_of_second_last_terms;
    }
}