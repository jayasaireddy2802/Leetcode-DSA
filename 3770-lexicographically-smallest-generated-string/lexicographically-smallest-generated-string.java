class Solution {
    public boolean isSame(char[] word, String str2, int idx)
    {
        int i = idx;
        for(int j = 0; j < str2.length(); j++)
        {
            if(word[i] != str2.charAt(j)) return false;
            i++;
        }

        return true;
    }
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] word = new char[n + m - 1];
        boolean[] canChange = new boolean[n + m - 1];

        for(int i = 0; i < n; i++)
        {
            if(str1.charAt(i) == 'T')
            {
                int idx = i;
                for(int j = 0; j < m; j++)
                {
                    if(word[idx] != 0 && word[idx] != str2.charAt(j)) return "";
                    word[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        for(int i = 0; i < n + m - 1; i++)
        {
            if(word[i] == 0)
            {
                word[i] = 'a';
                canChange[i] = true;
            }
        }


        for(int i = 0; i < n; i++)
        {
            if(str1.charAt(i) == 'F')
            {
                if(isSame(word, str2, i))
                {
                    boolean changed = false;
                    
                    for(int j = i + m - 1; j >= i; j--)
                    {
                        if(canChange[j])
                        {
                            word[j] = 'b';
                            changed = true;
                            break;
                        }
                    }
                    if(!changed) return "";
                }
            }
        }

        return new String(word);
    }
}