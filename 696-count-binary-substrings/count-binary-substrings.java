class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int curr = 0;
        int len = s.length();
        char ch = s.charAt(0);
        int ct = 0;

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == ch)
                curr++;
            else
            {
                ct += Math.min(curr, prev);
                prev = curr;
                curr = 1;
                ch = s.charAt(i);
            }
        }

        ct += Math.min(curr, prev);

        return ct;
    }
}