class Solution {
    public boolean isValid(String word) {
        int len = word.length();
        if(len < 3)
            return false;

        boolean anyVowel = false;
        boolean anyConsonant = false;

        for(int i = 0; i < len; i++)
        {
            char ch = word.charAt(i);

            if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            {
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                {
                    anyVowel = true;
                }
                else
                {
                    if(ch >= '0' && ch <= '9')
                        continue;
                    else
                        anyConsonant = true;
                }
            }

            else
            {
                return false;
            }
        }

        return (anyVowel && anyConsonant);

    }
}