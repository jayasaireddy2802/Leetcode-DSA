class Solution {

    public boolean containsZero(int num)
    {
        String str = Integer.toString(num);
        int j = 0;
        int len = str.length();

        while(j < len)
        {
            if(str.charAt(j) == '0')
                return true;
            j++;
        }

        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];

        int i = 0;
        while(i < n)
        {   
            i++;
            int a = i;
            int b = n - i;

            if(containsZero(a) || containsZero(b))
                continue;
            ans[0] = a;
            ans[1] = b;
            return ans;
        }

        return ans;
        
    }
}