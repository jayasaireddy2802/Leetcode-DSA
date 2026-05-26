class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];
        int len = word.length();
        int ans = 0;

        for(int i = 0; i < len; i++)
        {
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z')
            {
                lowerCase[ch - 'a'] = true;
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                upperCase[ch - 'A'] = true;
            }
        }

        for(int i = 0; i < 26; i++)
        {
            if(lowerCase[i] && upperCase[i])
                ans++;
        }
        

        return ans;
    }
}