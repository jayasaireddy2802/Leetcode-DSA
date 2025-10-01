// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
//         int sum = 0;
//         int empty = 0;
//         int full = numBottles;

//         while(full >= numExchange)
//         {
//             sum = sum + numExchange;
//             full = full - numExchange;
//             full++;
//         }

//         return sum + full;
//     }
// }

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int empty = numBottles;

        while(empty >= numExchange)
        {
            int extra = empty / numExchange;
            int remain = empty % numExchange;

            sum = sum + extra;
            empty = remain + extra;
        }

        return sum ;
    }
}