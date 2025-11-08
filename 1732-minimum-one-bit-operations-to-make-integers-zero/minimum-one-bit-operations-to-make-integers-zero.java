class Solution {
    public int minimumOneBitOperations(int n) {
        int mask = n;

        while(mask > 0)
        {
            mask = mask >> 1;
            n = n ^ mask;
        }

        return n;
    }
}