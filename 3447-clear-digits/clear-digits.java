class Solution {
    public String clearDigits(String s) {
        int len = s.length();
        int j;
        StringBuilder sb = new StringBuilder(s);
        int i =0;
        while(i < sb.length())
        {
            char ch = sb.charAt(i);
            if(ch >= '0' && ch <= '9')
            {
                j = i-1;
                while(j >= 0)
                {
                    if(sb.charAt(j) >= 'a' && sb.charAt(j) <= 'z')
                    {
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(j);
                        i = -1;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return sb.toString();
    }
}