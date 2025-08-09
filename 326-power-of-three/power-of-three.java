class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        
        int num = n;

        while(num > 1)
        {
            if(num % 3 == 0)
                num /= 3;
            else
                return false;
        }

        return true;
    }
}