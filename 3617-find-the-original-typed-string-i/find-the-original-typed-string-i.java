class Solution {
    public int possibleStringCount(String word) {
        int ct = 1;
        int len = word.length();

        for(int i = 1; i < len; i++)
        {   
            if(word.charAt(i) == word.charAt(i-1))
                ct++;
        }

        return ct;
    }
}