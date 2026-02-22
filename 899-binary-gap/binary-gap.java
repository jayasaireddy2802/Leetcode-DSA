class Solution {
    public int binaryGap(int n) {
        String binaryString = Integer.toString(n, 2);
        int prevOne = -1;
        int len = binaryString.length();
        int ans = 0, i = 0;

        while(i < len)
        {
            if(binaryString.charAt(i) == '1')
            {
                if(prevOne == -1)
                    prevOne = i;
                else
                {
                    ans = Math.max(ans, i - prevOne);
                    prevOne = i;
                }
            }
            i++;
        }


        return ans;
    }
}