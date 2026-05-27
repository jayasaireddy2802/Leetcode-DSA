class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];
        int[] notSpecial = new int[26];
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
                if(lowerCase[ch - 'A'] && notSpecial[ch - 'A'] != 2)
                    notSpecial[ch - 'A'] = 1;
            }

            if(ch >= 'a' && ch <= 'z' && upperCase[ch - 'a'])
            {
                notSpecial[ch - 'a'] = 2;
            }
            
        }

        for(int num : notSpecial)
            if(num == 1) ans++;

        return ans;

    }
}