class Solution {
    String res = "";

    public boolean isSubsequence(String currString, String str, int k)
    {
        // for(int i = 0; i < k; i++)
        // {
        //     str += str;
        // }

        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < k; i++) {
            repeated.append(currString);
        }
        String repeatedStr = repeated.toString();

        int i = 0;
        int j = 0;
        int len1 = str.length();
        int len2 = repeatedStr.length();

        while(i < len1 && j < len2)
        {
            if(str.charAt(i) == repeatedStr.charAt(j))
            {
                j++;
            }
            i++;
        }

        return (j == len2);
    }

    public void generatePossibleStrings(String str, String currString, int maxLength, boolean[] canUse, int[] freq, int k)
    {
        int len = currString.length();

        if(len > maxLength)
        {   
            return ;
        }

        if (isSubsequence(currString, str, k)) {
            if (len > res.length() || (len == res.length() && currString.compareTo(res) > 0)) {
                    res = currString;
            }
        }

        for(int i = 0; i < 26; i++)
        {
            if(canUse[i] && freq[i] > 0)
            {
                String newString = currString + (char)('a' + i);
                freq[i]--;
                generatePossibleStrings(str, newString, maxLength, canUse, freq, k);
                
                freq[i]++;
            }
        }
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int len = s.length();
        int maxLength = len / k;
        boolean[] canUse = new boolean[26];
        int[] freq = new int[26];

        for(int i = 0; i < len; i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            if(freq[i] >= k)
            {
                canUse[i] = true;
                freq[i] = freq[i] / k;
            }
        }

        generatePossibleStrings(s, "", maxLength, canUse, freq, k);
        
        return res;

    }
}