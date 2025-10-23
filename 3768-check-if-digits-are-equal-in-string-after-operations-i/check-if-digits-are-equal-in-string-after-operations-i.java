class Solution {
    public boolean hasSameDigits(String s) {
        int len = s.length();
        StringBuilder ans = new StringBuilder(s);

        while(len > 2)
        {
            StringBuilder str = new StringBuilder();
            int i = 0;
            while(i < len - 1)
            {
                char val = (char)(((ans.charAt(i) - '0') + (ans.charAt(i + 1) - '0')) % 10 + '0');
                str.append(val);
                i++;
            }
            ans = str;
            len = str.length();
        }
        return (ans.charAt(0) == ans.charAt(1));
    }
}