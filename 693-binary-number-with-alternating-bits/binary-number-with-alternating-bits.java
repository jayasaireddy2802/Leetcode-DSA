class Solution {
    public boolean hasAlternatingBits(int n) {
        int currBit = (n & 1);
        n = n >> 1;
        int nextBit;

        while(n > 0)
        {
            nextBit = (n & 1);
            if(nextBit == currBit)
                return false;
            currBit = nextBit;
            n = n >> 1;
        }

        return true;
    }
}