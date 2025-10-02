class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int consumed = numBottles;
        int empty = numBottles;

        while(empty >= numExchange)
        {
            empty -= numExchange;
            consumed++;
            empty++;
            numExchange++;
        }

        return consumed;
    }
}