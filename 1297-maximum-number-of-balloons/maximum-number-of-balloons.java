class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        int len = text.length();
        int ct = Integer.MAX_VALUE;
        char[] arr = {'b', 'a', 'l', 'o', 'n'};

        for(int i = 0; i < len; i++)
        {
            freq[text.charAt(i) - 'a']++;
        }

        for(char ch : arr)
        {
            if(ch == 'l' || ch == 'o')
            {
                ct = Math.min(ct, freq[ch - 'a'] / 2);
            }
            else
                ct = Math.min(ct, freq[ch - 'a']);

        }

        return ct;
    }
}