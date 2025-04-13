class Solution {

    public int power(int a, long b, int mod)
    {
        if(b == 0)
            return 1;
        if(b == 1)
            return a % mod;
        
        int half = power(a, b/2, mod);
        long result = ((long) half * half) % mod;

        if(b%2 == 1)
            result = (result * a)% mod;
        
        return (int)result;
    }

    public int countGoodNumbers(long n) {
        int mod = (int)(1e9 + 7);
        int ans1 = power(5, (n+1)/2, mod);
        int ans2 = power(4, (n/2), mod);
        long res =  ((long)ans1 * ans2) % mod;
        return (int)res;
    }
}