// class Solution {

//     public int sumOfDigits(int num)
//     {
//         int sum = 0;
//         while(num > 0)
//         {
//             sum += num % 10;
//             num = num / 10;
//         }
//         return sum;
//     }

//     public int productOfDigits(int num)
//     {
//         int val = 1;
//         while(num > 0)
//         {
//             val *= num % 10;
//             num = num / 10;
//         }
//         return val;
//     }

//     public boolean checkDivisibility(int n) {
//         int sum = sumOfDigits(n);
//         int product = productOfDigits(n);
//         return (n % (sum + product) == 0) ? true : false;
//     }
// }

class Solution {
    public boolean checkDivisibility(int n) {
        int product = 1;
        int sum = 0;
        int num = n;
        while(num > 0)
        {
            int rem = num % 10;
            sum += rem;
            product *= rem;
            num = num / 10;
        }
        return (n % (sum + product) == 0) ? true : false;
    }
}

