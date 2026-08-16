class Solution {
    public boolean stoneGameIX(int[] stones) {
        int ct0 = 0;
        int ct1 = 0;
        int ct2 = 0;
        int len = stones.length;

        for(int i = 0; i < len; i++)
            stones[i] = stones[i] % 3;

        for(int stone : stones)
        {
            if(stone == 0) ct0++;
            if(stone == 1) ct1++;
            if(stone == 2) ct2++;
        }

        if(ct0 % 2 == 0)
            return (ct1 >= 1 && ct2 >= 1) ? true : false;
        if(ct0 % 2 == 1)
            return (Math.abs(ct1 - ct2) > 2) ? true : false;
        return false;
        
    }
}