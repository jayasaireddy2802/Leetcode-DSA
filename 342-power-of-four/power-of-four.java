class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0)
            return false;

        int num = n;

        while(num%4 == 0)
        {
            num /= 4;
        }

        return (num == 1) ? true : false;
    }
}