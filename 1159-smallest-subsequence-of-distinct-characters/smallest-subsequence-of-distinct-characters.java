class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int[] lastidx = new int[26];
        boolean[] taken = new boolean[26];

        for(int i = 0; i < len; i++)
        {
            lastidx[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < len; i++)
        {
            int size = sb.length();
            char ch = s.charAt(i);

            if (taken[ch - 'a']) continue;

            if(size == 0 || sb.charAt(size - 1) < ch)
            {
                sb.append(ch);
                taken[ch - 'a'] = true;
            }

            else
            {
                size--;
                while(size >= 0 && sb.charAt(size) > ch && lastidx[sb.charAt(size) - 'a'] > i)
                {
                    char c = sb.charAt(size);
                    sb.deleteCharAt(size);
                    size--;
                    taken[c - 'a'] = false;
                }
                sb.append(ch);
                taken[ch - 'a'] = true;
            }
        }
        return sb.toString();
    }
}