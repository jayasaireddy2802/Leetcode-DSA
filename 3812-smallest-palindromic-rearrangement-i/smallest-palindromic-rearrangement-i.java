class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int[] freq = new int[26];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char oddChar = 'A';

        for(int i = 0; i < len; i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            char ch = (char)('a' + i);

            if(freq[i] != 0)
            {
                int val = freq[i] / 2;
                if(freq[i] % 2 == 1)
                    oddChar = ch;
                
                while(val > 0){
                    sb1.append(ch);
                    sb2.append(ch);
                    val--;
                }
            }
        }

        if(oddChar != 'A')
            sb1.append(oddChar);
        sb2 = sb2.reverse();

        sb1.append(sb2);

        return sb1.toString();

    }
}