class Solution {
    public boolean checkStrings(String s1, String s2) {
        int len = s1.length();
        int[] evenChar = new int[26];
        int[] oddChar = new int[26];

        for(int i = 0; i < len; i++)
        {
            if(i % 2 == 0)
            {
                evenChar[s1.charAt(i) - 'a']++;
                evenChar[s2.charAt(i) - 'a']--;
            }
            else
            {
                oddChar[s1.charAt(i) - 'a']++;
                oddChar[s2.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++)
        {
            if(evenChar[i] != 0 || oddChar[i] != 0) return false;        
        }

        return true;
    }
}