class Solution {
    public boolean checkOnesSegment(String s) {
        int len = s.length();
        boolean zeroFound = false;

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '0')
                zeroFound = true;

            if(zeroFound && s.charAt(i) == '1')
                return false;
        }

        return true;
    }
}