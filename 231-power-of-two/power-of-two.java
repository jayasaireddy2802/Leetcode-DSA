class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n <= 0)
            return false;

        int num = n;
        while(num > 1)
        {
            if(num % 2 == 0)
                num /= 2;
            else
                return false;
        }
        return true;

    }
}