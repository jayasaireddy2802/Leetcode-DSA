class Solution {
    public int reverse(int num)
    {
        int val = 0;
        while(num > 0)
        {
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val;
    }
    public int mirrorDistance(int n) {
        
        int reverseNum = reverse(n);
        return Math.abs(n - reverseNum);
    }
}