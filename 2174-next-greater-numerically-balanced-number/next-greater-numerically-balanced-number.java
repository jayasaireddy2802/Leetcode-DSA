class Solution {

    public boolean isBalanced(int num)
    {
        int[] freq = new int[10];

        while(num > 0)
        {
            freq[num % 10]++;
            num /= 10;
        }

        for(int i = 0; i <= 9; i++)
        {
            if(freq[i] != i && freq[i] != 0)
                return false;
        }

        return true;
    }
    public int nextBeautifulNumber(int n) {
        
        n++;
        while(n < 100000007)
        {
            if(isBalanced(n))
                return n;
            n++;
        }

        return -1;
    }
}