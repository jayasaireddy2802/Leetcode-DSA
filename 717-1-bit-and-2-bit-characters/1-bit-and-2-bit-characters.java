class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;

        while(i < len)
        {
            if(i == len - 1)
                return true;
            if(bits[i] == 1)
                i = i + 2;
            else
                i++;
        }

        return false;
    }
}