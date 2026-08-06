class Solution {

    public boolean isPossible(int n, int t)
    {
        long product = 1;

        while(n > 0)
        {
            product *= (n % 10);
            n /= 10;
        }

        return product % t == 0;
    }

    public int smallestNumber(int n, int t) {

        while(true)
        {
            if(isPossible(n, t))
                return n;
            n++;
        }
        
    }
}