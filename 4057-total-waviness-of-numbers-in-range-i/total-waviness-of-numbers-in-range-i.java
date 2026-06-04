class Solution {

    public int getPeaksCount(String str)
    {
        int ct = 0;
        int len = str.length();

        for(int i = 1; i < len - 1; i++)
        {
            if(str.charAt(i) > str.charAt(i - 1)  && str.charAt(i) > str.charAt(i + 1))
                ct++;
        }

        return ct;
    }

    public int getValleysCount(String str)
    {
        int ct = 0;
        int len = str.length();

        for(int i = 1; i < len - 1; i++)
        {
            if(str.charAt(i) < str.charAt(i - 1)  && str.charAt(i) < str.charAt(i + 1))
                ct++;
        }

        return ct;
    }

    public int totalWaviness(int num1, int num2) {
        int totalCount = 0;

        for(int i = num1; i <= num2; i++)
        {
            String str = Integer.toString(i);

            int peaks = getPeaksCount(str);
            int valleys = getValleysCount(str);

            totalCount += peaks + valleys;
        }

        return totalCount;
    }
}