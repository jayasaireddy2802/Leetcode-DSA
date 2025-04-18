class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++)
        {
            s = countAndSay(s);
        }

        return s;
    }

    public String countAndSay(String s)
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int len = s.length();
        char prevChar = s.charAt(0);

        for(int i = 1; i < len; i++)
        {
            if(prevChar == s.charAt(i))
                count++;
            else
            {
                sb.append(count);
                sb.append(prevChar);
                count = 1;
                prevChar = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(prevChar);

        return sb.toString();
    }
}