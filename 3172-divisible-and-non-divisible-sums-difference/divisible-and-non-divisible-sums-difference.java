// class Solution {
//     public int differenceOfSums(int n, int m) {
//         int divisibleSum = 0;
//         int notDivisibleSum = 0;

//         for(int i = 1; i <= n; i++)
//         {
//             if(i % m == 0)
//                 divisibleSum += i;
//             else
//                 notDivisibleSum += i;
//         }

//         return notDivisibleSum - divisibleSum;
//     }
// }

class Solution {
    public int differenceOfSums(int n, int m) {

        int sumOfNumbersTillN = (n*(n+1)) / 2;
        int terms = n / m;
        int divisibleSum = m * terms * (terms + 1) / 2;

        return sumOfNumbersTillN - (2 * divisibleSum);

    }
}