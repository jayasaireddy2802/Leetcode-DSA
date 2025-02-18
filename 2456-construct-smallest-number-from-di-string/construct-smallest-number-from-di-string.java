class Solution {
    public String smallestNumber(String pattern) {
        int len = pattern.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= len + 1; i++)
        {
            sb.append(Integer.toString(i));
        }

        int i = 0;
        int j = 0;
        while(i < len)
        {
            if(pattern.charAt(i) == 'I')
                i++;
            else
            {
                j = i;
                while(i < len && pattern.charAt(i) == 'D')
                {
                    i++;
                }
                sb.replace(j, i + 1, new StringBuilder(sb.substring(j, i + 1)).reverse().toString());
            }

        }
        return sb.toString();
    }
}