// class Solution {
//     public int countOperations(int num1, int num2) {
//         int ct = 0;

//         while(num1 > 0 && num2 > 0)
//         {
//             if(num1 >= num2)
//                 num1 -= num2;
//             else
//                 num2 -= num1;
//             ct++;
//         }

//         return ct;
//     }
// }


class Solution {
    public int countOperations(int num1, int num2) {
        int ct = 0;

        if(num2 > num1)
        {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        while(num1 > 0 && num2 > 0)
        {
            ct = ct + (num1 / num2);
            num1 = num1 % num2;
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        return ct;


    }
}