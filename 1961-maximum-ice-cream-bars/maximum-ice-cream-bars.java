class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int ct = 0;

        Arrays.sort(costs);
        for(int cost : costs)
        {
            if(coins >= cost)
            {
                ct++;
                coins -= cost;
            }
        }

        return ct;
    }
}