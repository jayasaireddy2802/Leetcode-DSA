class Solution {

    private boolean isVowel(char ch)
    {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public int maxFreqSum(String s) {
        int vowelFreq = 0;
        int consonantFreq = 0;
        int[] freq = new int[158];

        
        for(char ch : s.toCharArray())
        {
            freq[ch - 'a']++;
            if(isVowel(ch))
                vowelFreq = Math.max(vowelFreq, freq[ch - 'a']);
            else
                consonantFreq = Math.max(consonantFreq, freq[ch - 'a']);;
        }

        return vowelFreq + consonantFreq;
    }
}