class Solution {

    private boolean isVowel(char ch)
    {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public boolean doesAliceWin(String s) {
        int ct = 0;

        for(char ch : s.toCharArray())
        {
            if(isVowel(ch))
                ct++;
        }

        if(ct == 0)
            return false;
        else
            return true;

    }
}