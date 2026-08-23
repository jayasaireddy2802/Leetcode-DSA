class Solution {
    public boolean sumGame(String num) {
        int left = 0;
        int right = 0;
        int sum1 = 0;
        int sum2 = 0;
        int len = num.length();

        for(int i = 0; i < len; i++)
        {
            if(num.charAt(i) == '?')
            {
                if(i < len / 2)
                    left++;
                else
                    right++;
            }
            else
            {
                if(i < len / 2)
                    sum1 += num.charAt(i) - '0';
                else
                    sum2 += num.charAt(i) - '0';
            }
        }

        if((left + right) % 2 == 1) return true;

        int leftSum = 2 * sum1 + 9 * left;
        int rightSum = 2 * sum2 + 9 * right;

        return (leftSum == rightSum) ? false : true;
            
    }
}